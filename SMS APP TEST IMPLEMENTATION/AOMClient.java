import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AOMClient {

    private static final String BASE_URL = "https://aom-vmovtyc2ya-uc.a.run.app/api";

    public static void createSubscriber() {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Please enter the following information:");
            System.out.print("MSISDN (Phone Number): ");
            String msisdn = sc.nextLine();
            System.out.print("Package ID: ");
            int packageID = Integer.parseInt(sc.nextLine());
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Surname: ");
            String surname = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            System.out.print("Security Key: ");
            String securityKey = sc.nextLine();
            
            // Construct JSON body
            String jsonBody = "{\"msisdn\":\"" + msisdn + "\",\"packageID\":" + packageID + ",\"name\":\"" + name + "\",\"surname\":\"" + surname + "\",\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"securitykey\":\"" + securityKey + "\"}";
            System.out.println("Request Body: " + jsonBody);

            // Set up HTTP connection
            String url = BASE_URL + "/customer/register";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            
            // Write JSON body to the connection
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            // Get response code
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Subscriber created successfully!");
            } else {
                System.out.println("Error: HTTP response code - " + responseCode);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static String loginSubscriber() {

        Scanner sc = new Scanner(System.in);

        System.out.print("MSISDN (Phone Number): ");
        String msisdn = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        // Construct JSON body
        String jsonBody = "{\"msisdn\":\"" + msisdn + "\",\"password\":\"" + password + "\"}";
        System.out.println("Request Body: " + jsonBody);


        // Set up HTTP connection to  login
        try {

            String url = BASE_URL + "/customer/login";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);


            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            // Get response code
            int responseCode = connection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK)
                System.out.println("Error: HTTP response code - " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                response.append(responseLine.trim());
            }

            // Parse the JSON response to get the token
            JSONObject jsonResponse = new JSONObject(response.toString());
            String token = jsonResponse.getString("token");

            System.out.println("Logged in successfully!");
            System.out.println("Token: " + token);

            return token;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showRemainingBalanceList(String token) {
        try {
            String url = BASE_URL + "/customer/balance";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                System.out.println("Remaining Balance List:");
                System.out.println
                (response.toString());
                in.close();
            } else {
                System.out.println("Error: HTTP response code - " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendSMSMessage(String token) {
        // Implement sending SMS message functionality
        System.out.println("Sending SMS Message...");
    }

    public static void viewSMSInbox(String token) {
        // Implement viewing SMS inbox functionality
        System.out.println("Viewing SMS Inbox...");
    }

    public static void userLogout(String token) {
        // Implement user logout functionality
        System.out.println("Logging out...");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Operator Web Selfcare");
            System.out.println("1. Create Subscriber");
            System.out.println("2. Show Remaining Balance List");
            System.out.println("3. Send SMS Message");
            System.out.println("4. View SMS Inbox");
            System.out.println("5. User Logout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createSubscriber();
                    break;
                case 2:
                    System.out.println("Please log in to retrieve the remaining balance list.");
                    String token = loginSubscriber();
                    if (token != null && !token.isEmpty()) {
                        showRemainingBalanceList(token);
                    }
                    break;
                case 3:
                    System.out.println("Please log in to send an SMS message.");
                    token = loginSubscriber();
                    if (token != null && !token.isEmpty()) {
                        sendSMSMessage(token);
                    }
                    break;
                case 4:
                    System.out.println("Please log in to view the SMS inbox.");
                    token = loginSubscriber();
                    if (token != null && !token.isEmpty()) {
                        viewSMSInbox(token);
                    }
                    break;
                case 5:
                    System.out.println("Logging out...");
                    token = loginSubscriber();
                    if (token != null && !token.isEmpty()) {
                        userLogout(token);
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
