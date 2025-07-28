import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        URLShortener shortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\n--- URL Shortener ---");
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand Short URL");
            System.out.println("3. Print All Mappings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;

            try
            {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException ignored)
            {
                // Ignored
            }

            switch (choice)
            {
                case 1:
                {
                    System.out.print("Enter long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = shortener.shortenURL(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;
                }

                case 2:
                {
                    System.out.print("Enter short URL: ");
                    String shortInput = scanner.nextLine();
                    String originalUrl = shortener.expandURL(shortInput);

                    if(originalUrl == null)
                    System.out.println("URL not found.");

                    else
                    System.out.println("Original URL: " + originalUrl);

                    break;
                }

                case 3:
                {
                    shortener.printAllMappings();
                    break;
                }

                case 4:
                {
                    System.out.println("Exiting...");
                    return;
                }

                default:
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
