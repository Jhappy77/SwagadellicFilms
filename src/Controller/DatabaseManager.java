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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
			JSONArray j = readJsonArrayFromUrl(URL);
			for(int i = 0; i < j.length(); i++) {
				int id = j.getJSONObject(i).getInt("id");
				String movie_name = j.getJSONObject(i).getString("movie_name");
				String genre = j.getJSONObject(i).getString("genre");
				String release_date = j.getJSONObject(i).getString("release_date");
				Date date = format.parse(release_date);
				Movie m = new Movie(movie_name, genre, String.valueOf(id), date);
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
			JSONArray j = readJsonArrayFromUrl(URL);
			for(int i = 0; i < j.length(); i++) {
				int id = j.getJSONObject(i).getInt("id");
				String movie_name = j.getJSONObject(i).getString("movie_name");
				String genre = j.getJSONObject(i).getString("genre");
				String release_date = j.getJSONObject(i).getString("release_date");
				Date date = format.parse(release_date);
				Movie m = new Movie(movie_name, genre, String.valueOf(id), date);
				movieList.add(m);
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return movieList;
	}
	
	public List<MovieTheatre> queryTheatresWithMovie(String movieId) {
		String URL = baseURL + "theatre?format=json&movieId=" + movieId;
		List<MovieTheatre> theatreList = new ArrayList<MovieTheatre>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			JSONArray j = readJsonArrayFromUrl(URL);
			for(int i = 0; i < j.length(); i++) {
				int id = j.getJSONObject(i).getInt("id");
				String theatre_name = j.getJSONObject(i).getString("theatre_name");
				String address = j.getJSONObject(i).getString("address");
				String theatre_type = j.getJSONObject(i).getString("theatre_type");
				MovieTheatre m = new MovieTheatre(address, theatre_name, String.valueOf(id), theatre_type);
				theatreList.add(m);
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return theatreList;
	}
	
	// screeningId and element in theatreList MUST match for this function to work
	// I also need to consider both EARLY screenings and REGULAR screenings
	public List<MovieScreening> queryScreeningsAtTheatre(String movieId, String theatreId) {
		String URL = baseURL + "screening?format=json&movieId=" + movieId + "&theatreId=" + theatreId;
		List<MovieScreening> screeningList = new ArrayList<MovieScreening>();
		try {
			JSONArray j = readJsonArrayFromUrl(URL);
			for(int k = 0; k < j.length(); k++) {
				int id = j.getJSONObject(k).getInt("id");
				String screening_time = j.getJSONObject(k).getString("screening_time");
				LocalDateTime ldt = LocalDateTime.parse(screening_time);
				
				// find Movie
				List<Movie> m = queryMovies();
				String movieName = "";
				for(int i = 0; i < m.size(); i++) {
					if(m.get(i).getId().contentEquals(movieId))
						movieName = m.get(i).getName();
					continue;
				}
				
				// find Theatre
				List<MovieTheatre> mt = queryTheatresWithMovie(movieId);
				String theatreName = "";
				for(int i = 0; i < mt.size(); i ++) {
					if(mt.get(i).getId().contentEquals(theatreId))
						theatreName = mt.get(i).getName();
					continue;
				}
				
				MovieScreening ms = new MovieScreening(ldt, theatreName, movieName, String.valueOf(id));
				screeningList.add(ms);
			}
		} catch (IOException | JSONException | ParseException e) {
			e.printStackTrace();
		}
		return screeningList;
	}
	
	public Ticket queryTicket(String ticketId) {
        String URL = baseURL + "ticket?format=json&ticketId=" + ticketId;
        try {
            JSONObject j = readJsonFromUrl(URL);
            if (j.has(ticketId)) {
               Ticket t = new Ticket(ticketId, movieScreening);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
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
//		public static void main(String[] args) throws ParseException {
//			DatabaseManager inst = DatabaseManager.getInstance();
//			try {
//				System.out.println("Testing");
//				JSONArray j = inst.readJsonArrayFromUrl("https://calm-shelf-23678.herokuapp.com/swagDB/ticket?format=json&ticketId=1");
//				System.out.println(j.length());
//				System.out.println(j);
//				for(int i = 0; i < j.length(); i++) {
//					int id = j.getJSONObject(i).getInt("id");
//					String movie_name = j.getJSONObject(i).getString("screening_time");
//					String genre = j.getJSONObject(i).getString("genre");
//					String release_date = j.getJSONObject(i).getString("release_date");
//					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//					Date date = format.parse(release_date);
//					MovieScreening m = new MovieScreening(movie_name, genre, String.valueOf(id), date);
//					System.out.println(m.getGenre() + "   " + m.getId() + "   " + m.getName() + "   " + m.getReleaseDate());
//				}
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
}
