package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
<<<<<<< HEAD
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
=======
import java.util.List;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import java.util.Map;
import java.util.StringJoiner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Model.Cart;
import Model.CreditMethod;
import Model.DebitMethod;
import Model.Movie;
import Model.MovieScreening;
import Model.MovieTheatre;
import Model.Payment;
import Model.RegisteredUser;
import Model.Ticket;

public class DatabaseManager {
	
	private static URL apiUrl;
	private static String baseURL;
	private static HttpURLConnection connection;
	private static DatabaseManager theDatabaseManager;
	
	private DatabaseManager() {
		baseURL = "https://calm-shelf-23678.herokuapp.com/swagDB/";
	}
	
	public static DatabaseManager getInstance() {
		if(theDatabaseManager == null)
			theDatabaseManager = new DatabaseManager();
		return theDatabaseManager;
	}
	
<<<<<<< HEAD
	public List<Integer> queryBookedSeats(String screeningId) {
		//PLACEHOLDER - Can replace with real query function when made
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(5);
		li.add(8);
		li.add(24);
		li.add(53);
		li.add(87);
		li.add(88);
		return li;
	}
	
	// How do I get screening_id and user_id from this?
	public void saveTicket(Ticket ticketToAdd) throws IOException, JSONException {  
        processUrl("save-ticket");
        Map<String,String> arguments = new HashMap<>();
        arguments.put("ticket_id", ticketToAdd.getId());
        arguments.put("seat_no", ticketToAdd.getSeatNumber());
=======
	// How do I get screening_id and user_id from this?
	public void saveTicket(Ticket ticketToAdd) throws IOException, JSONException {  
        processMethod("save-ticket", "POST");
        Map<String,String> arguments = new HashMap<>();
        arguments.put("ticket_id", ticketToAdd.getId());
        arguments.put("seat_no", Integer.toString(ticketToAdd.getSeatNumber()));
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
        arguments.put("screening_id", ticketToAdd.getScreening().getId());
        // PUT USER ID
        processPost(arguments);
	}
	
<<<<<<< HEAD
	// need to implement payment first
	public void savePayment(Payment thePayment) throws IOException, JSONException {
        URL url = new URL(baseURL + "save-payment");
        URLConnection con = url.openConnection();
        connection = (HttpURLConnection)con;
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        
=======
	public void removeTicket(String ticketId) throws IOException {
		processMethod("delete-ticket", "DELETE");
		Map<String, String> arguments = new HashMap<>();
		arguments.put("pk", ticketId);
		processPost(arguments);
	}
	
	// need to implement payment first
	public void savePayment(Payment thePayment) throws IOException, JSONException {
		processMethod("save-payment", "POST");
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
        Map<String,String> arguments = new HashMap<>();
        arguments.put("amount", String.valueOf(thePayment.getAmount()));
        arguments.put("user_id", thePayment.getID()); // should this be payment ID?
        processPost(arguments);
	}
	
	// need to implement registereduser first
	public void saveRegisteredUser(RegisteredUser userInfo) throws JSONException, IOException {
<<<<<<< HEAD
		String URL = baseURL + "register-user";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("name", userInfo.getName()); //
        objItem.put("birthdate",  userInfo.getDateOfBirth()); //
        objItem.put("password", userInfo.getPassword()); //
        objItem.put("email",  userInfo.getEmail()); //
        jsonArray.put(objItem);
=======
		processMethod("registered-user", "POST");
		Map<String,String> arguments = new HashMap<>();
		arguments.put("name", userInfo.getName()); //
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		arguments.put("birthdate",  dateFormat.format(userInfo.getDateOfBirth())); //
		arguments.put("password", userInfo.getPassword()); //
		arguments.put("email",  userInfo.getEmail()); //
		processPost(arguments);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}
	
	// need to implement
	public void saveCreditInfo(RegisteredUser regUser, CreditMethod credit) throws IOException, JSONException {
<<<<<<< HEAD
		String URL = baseURL + "save-credit";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("user_id", regUser.getEmail()); //
        objItem.put("credit_number",  credit.getNumber()); //
        jsonArray.put(objItem);
=======
		processMethod("save-credit", "POST");
		Map<String,String> arguments = new HashMap<>();
		arguments.put("user_id", regUser.getEmail()); //
		arguments.put("credit_number",  String.valueOf(credit.getNumber())); //
		processPost(arguments);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}
	
	// need to implement
	public void saveDebitInfo(RegisteredUser regUser, DebitMethod debit) throws JSONException, IOException {
<<<<<<< HEAD
		String URL = baseURL + "save-debit";
		JSONArray jsonArray = new JSONArray();
        JSONObject objItem = readJsonFromUrl(URL);
        objItem.put("user_id", regUser.getEmail()); //
        objItem.put("debit_number",  debit.getNumber()); //
        jsonArray.put(objItem);
=======
		processMethod("save-debit", "POST");
		Map<String,String> arguments = new HashMap<>();
		arguments.put("user_id", regUser.getEmail()); //
		arguments.put("debit_number", String.valueOf(debit.getNumber())); //
        processPost(arguments);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}
	
	public boolean validateLogin(String username, String password) throws IOException, JSONException {
		String URL = baseURL + "login?email=" + username + "&password=" + password;
<<<<<<< HEAD
		JSONObject jsonFile = readJsonFromUrl(URL);
		if(!(jsonFile.has("Login Error")))
			return false;
		return true;
=======
		JSONObject j = readJsonFromUrl(URL);
		if(j.get("email").equals(username))
			return true;
		return false;
	}
	
	public void queryForRegisteredUser(String username, String password) throws JSONException, IOException {
		String URL = baseURL + "login?email=" + username + "&password=" + password;
		JSONObject j = readJsonFromUrl(URL);
		String name = j.getString("name");
		String birthdate = j.getString("birthdate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(birthdate);
		RegisteredUser(username, password, username, date, name);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
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
			for(int i = 0; i < j.length(); i++) {
				int DBMovieId = j.getJSONObject(i).getJSONObject("movie_id").getInt("id");
				String Mid = String.valueOf(DBMovieId);
				int DBTheatreId = j.getJSONObject(i).getJSONObject("theatre_id").getInt("id");
				String Tid = String.valueOf(DBTheatreId);
				if(movieId.equals(Mid) && theatreId.equals(Tid)) {
					String screening_time = j.getJSONObject(i).getString("screening_time");
					String date1 = "", date2 = "";
					int k =0 ;
//					while(k < 10)
//					{
//						char c = screening_time.charAt(k);
//						date1 += c;
//						date2 += c;
//					}
					while(k < screening_time.length()-6)
					{
						char c = screening_time.charAt(k);
						if(c=='T')
							c = ' ';
						date1 += c;
						k++;
					}
					
					//k++;
					
//					String date = "";
//					for(int k=0; k<screening_time.length(); k++)
//					{
//						if(screening_time.charAt(k) != 'T')
//							date+=screening_time.charAt(k);
//					}
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime ldt = LocalDateTime.parse(date1.toString(), formatter);
					String theatre_name = j.getJSONObject(i).getJSONObject("theatre_id").getString("theatre_name");
					String movie_name = j.getJSONObject(i).getJSONObject("movie_id").getString("movie_name");
					int id = j.getJSONObject(i).getInt("id");
					String id1 = String.valueOf(id);
					MovieScreening ms = new MovieScreening(ldt, theatre_name, movie_name, id1);
					screeningList.add(ms);
				}
			}
			
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return screeningList;
	}
	
<<<<<<< HEAD
=======
	public List<Integer> queryBookedSeats(String screeningId) {
		String URL = baseURL + "?format=json&screeningId=" + screeningId;
		List<Integer> bookedSeats = new ArrayList<Integer>();
        try {
            JSONArray j = readJsonArrayFromUrl(URL);
            for(int i = 0; i < j.length(); i++)
            	bookedSeats.add(j.getInt(i));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return bookedSeats;
	}
	
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	public Ticket queryTicket(String ticketId) {
        String URL = baseURL + "ticket?format=json&ticketId=" + ticketId;
        try {
            JSONObject j = readJsonFromUrl(URL);
            if (j.get("ticket_id").equals(ticketId)) {
            	String screening_time = j.getJSONObject("screening_id").getString("screening_time");
            	LocalDateTime ldt = LocalDateTime.parse(screening_time);
            	String screening_id = j.getJSONObject("screening_id").getString("id");
            	String movie_name = j.getJSONObject("screening_id").getJSONObject("movie_id").getString("movie_name");
            	String theatre_name = j.getJSONObject("screening_id").getJSONObject("theatre_id").getString("theatre_name");
            	MovieScreening ms = new MovieScreening(ldt, theatre_name, movie_name, screening_id);
<<<<<<< HEAD
            	String seat_num = j.getString("seat_no");
=======
            	int seat_num = Integer.parseInt(j.getString("seat_no"));
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
            	Ticket t = new Ticket(ticketId, ms, seat_num);
            	return t;
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
	
<<<<<<< HEAD
	public static void processUrl(String ext) throws IOException {
        apiUrl = new URL(baseURL + ext);
        URLConnection con = apiUrl.openConnection();
        connection = (HttpURLConnection)con;
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
	}
	 
	public static void processPost(Map<String,String> arguments) throws IOException {
        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        
=======
	public void processMethod(String ext, String method) throws IOException {
        apiUrl = new URL(baseURL + ext);
        URLConnection con = apiUrl.openConnection();
        connection = (HttpURLConnection)con;
        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        if (method.equals("DELETE"))
        	connection.connect();
	}
	 
	public void processPost(Map<String,String> arguments) throws IOException {
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String,String> entry : arguments.entrySet())
		    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
        connection.setFixedLengthStreamingMode(length);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        connection.connect();
        try(OutputStream os = connection.getOutputStream()) {
            os.write(out);
        }
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
//		public static void main(String[] args) throws ParseException, IOException {
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
<<<<<<< HEAD
//		}
			
//	        processUrl("save-ticket");
//			
//	        Map<String,String> arguments = new HashMap<>();
//	        arguments.put("ticket_id", "99");
//	        arguments.put("seat_no", "99");
//	        arguments.put("screening_id", "99");
//	        // PUT USER ID
//	        
//	        processPost(arguments);
//		}
}
=======
//		
//			
//	        inst.processMethod("save-debit", "POST");
//	        Map<String,String> arguments = new HashMap<>();
//	        arguments.put("user_id", "johncena@shaw.ca");
//	        arguments.put("debit_number", "99");
//	        inst.processPost(arguments);
//		}
}

>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
