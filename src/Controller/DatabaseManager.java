package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Model.CreditMethod;
import Model.DebitMethod;
import Model.Movie;
import Model.MovieScreening;
import Model.MovieTheatre;
import Model.Payment;
import Model.RegisteredUser;
import Model.Ticket;

public class DatabaseManager {
	
	private URL apiUrl;
	private String baseURL;
	private HttpURLConnection connection;
	private static DatabaseManager theDatabaseManager;
	
	private DatabaseManager() {
		baseURL = "https://calm-shelf-23678.herokuapp.com/swagDB/";
	}
	
	public static DatabaseManager getInstance() {
		if(theDatabaseManager == null)
			theDatabaseManager = new DatabaseManager();
		return theDatabaseManager;
	}
	
	public List<Integer> queryBookedSeats(String screeningId) {
		return null;
	}
	
	// How do I get screening_id and user_id from this?
	public void saveTicket(Ticket ticketToAdd) throws IOException, JSONException {
		String URL = baseURL + "save-ticket";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("ticket_id", ticketToAdd.getId());
        objItem.put("seat_no", ticketToAdd.getScreening().getSeats().get(0));
        objItem.put("screening_id", ticketToAdd.getScreening().getId()); //
//        objItem.put("user_id", ticketToAdd.get); //no need for id here cause anonymous user can use this method as well
        //delete user_id from database
        jsonArray.put(objItem);
	}
	
	// need to implement payment first
	public void savePayment(Payment thePayment) throws IOException, JSONException {
		String URL = baseURL + "save-payment";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("amount", thePayment.getAmount()); //
        objItem.put("user_id",  thePayment.getID()); //
        jsonArray.put(objItem);
	}
	
	// need to implement registereduser first
	public void saveRegisteredUser(RegisteredUser userInfo) throws JSONException, IOException {
		String URL = baseURL + "register-user";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("name", userInfo.getName()); //
        objItem.put("birthdate",  userInfo.getDateOfBirth()); //
        objItem.put("password", userInfo.getPassword()); //
        objItem.put("email",  userInfo.getEmail()); //
        jsonArray.put(objItem);
	}
	
	// need to implement
	public void saveCreditInfo(RegisteredUser regUser, CreditMethod credit) throws IOException, JSONException {
		String URL = baseURL + "save-credit";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("user_id", regUser.getEmail()); //
        objItem.put("credit_number",  credit.getNumber()); //
        jsonArray.put(objItem);
	}
	
	// need to implement
	public void saveDebitInfo(RegisteredUser regUser, DebitMethod debit) throws JSONException, IOException {
		String URL = baseURL + "save-debit";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("user_id", regUser.getEmail()); //
        objItem.put("debit_number",  debit.getNumber()); //
        jsonArray.put(objItem);
	}
	
	public boolean validateLogin(String username, String password) throws IOException, JSONException {
		String URL = baseURL + "login?email=" + username + "&password=" + password;
		JSONObject jsonFile = readJsonFromUrl(URL);
		if(!(jsonFile.has("Login Error")))
			return false;
		return true;
	}
	
	public List<Movie> queryMovies() throws ParseException {
		String URL = baseURL + "movies?format=json";
		List<Movie> movieList = new ArrayList<Movie>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			JSONObject jsonFile = readJsonFromUrl(URL);
			Iterator iterator = jsonFile.keys();
			JSONArray jsonArray = new JSONArray();
			while (iterator.hasNext()){
				String id = (String) iterator.next();
				String movie_name = (String) iterator.next();
				String genre = (String) iterator.next();
				Date release_date = (Date) format.parse((String) iterator.next());
				String length = (String) iterator.next(); // not used
				Movie m = new Movie(movie_name, genre, id, release_date);
				movieList.add(m);
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return movieList;
	}
	
	public List<Movie> queryMoviesWithEarlies() throws ParseException {
		String URL = baseURL + "early-movies?format=json";
		List<Movie> movieList = new ArrayList<Movie>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			JSONObject jsonFile = readJsonFromUrl(URL);
			Iterator iterator = jsonFile.keys();
			JSONArray jsonArray = new JSONArray();
			while (iterator.hasNext()) {
				String id = (String) iterator.next();
				String movie_name = (String) iterator.next();
				String genre = (String) iterator.next();
				Date release_date = (Date) format.parse((String) iterator.next());
				String length = (String) iterator.next(); // not used
				Movie m = new Movie(movie_name, genre, id, release_date);
				movieList.add(m);
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return movieList;
	}
	
	public List<MovieTheatre> queryTheatresWithMovie(String movieId) {
		String URL = baseURL + "theatre?movieId=" + movieId;
		List<MovieTheatre> theatreList = new ArrayList<MovieTheatre>();
		try {
			JSONObject jsonFile = readJsonFromUrl(URL);
			Iterator iterator = jsonFile.keys();
			while (iterator.hasNext()) {
				String id = (String) iterator.next();
				String theatre_name = (String) iterator.next();
				String address = (String) iterator.next();
				String theatre_type = (String) iterator.next(); // not used
				MovieTheatre mt = new MovieTheatre(address, theatre_name, id);
				theatreList.add(mt);
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return theatreList;
	}
	
	// How do i get the theatre and movie names from this?
	public List<MovieScreening> queryScreeningsAtTheatre(String movieId, String theatreId) {
		String URL = baseURL + "screening?movieId=" + movieId + "&theatreId=" + theatreId;
		List<MovieScreening> screeningList = new ArrayList<MovieScreening>();
		try {
			JSONObject jsonFile = readJsonFromUrl(URL);
			Iterator iterator = jsonFile.keys();
			while (iterator.hasNext()) {
				String id = (String) iterator.next();
				String screening_time = (String) iterator.next();
				LocalDateTime aLDT = LocalDateTime.parse(screening_time);
				//UNFINISHED
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return screeningList;
	}
	
	public boolean queryTicket(String ticketId) {
        String URL = baseURL + "ticket?tickedId=" + ticketId;
        try {
            JSONObject jsonFile = readJsonFromUrl(URL);
            if (jsonFile.get(ticketId) != null) {
               return true;
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	 public boolean queryPayment(String paymentId) {
	        String URL = baseURL + "payment?paymentId=" + paymentId;
	        try {
	            JSONObject jsonFile = readJsonFromUrl(URL);
	            if (jsonFile.get(paymentId) != null) {
	                return true;
	            }
	        } catch (IOException | JSONException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
	    } finally {
	    	is.close();
	    }
	}
	
	public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException{
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
	    } finally {
	    	is.close();
	    }
	}
	
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	    	sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	
	// USE THIS FOR TESTING
//		public static void main(String[] args) {
//			DatabaseManager inst = DatabaseManager.getInstance();
//			try {
//				System.out.println("Testing");
//				JSONArray j = inst.readJsonArrayFromUrl("https://calm-shelf-23678.herokuapp.com/swagDB/movies?format=json");
//				System.out.println(j.length());
//				System.out.println(j);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
}
