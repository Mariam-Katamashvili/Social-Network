# Social Network

This is a social networking web application developed using the Spring framework and MySQL as the database system. The primary goal of this project is to provide a platform for users to register, create and share text-based posts. Users will have personalized timelines that displays their posts and the posts of other users.

## Features

### User Registration and Authentication

- Users can create an account by providing their name, email, and password.
- Users can log in securely using their credentials.

### Profile Management

- User profiles will display the posts they've shared.

### Posting and Timeline

- Users can create text-based posts that are shared with other users.
- Posts will include text content and user's name.
- Users can search for other users to see their posts on their timeline.

[//]: # (## How the Project Works)

[//]: # ()
[//]: # (### ER Diagram of the Database)

[//]: # ()
[//]: # (This is the ER Diagram of the Project. We have following entities: User, Post, UserProfile, Following, Share.)

[//]: # ()
[//]: # (- The "User" entity represents individual users of the social media platform. It stores their personal information, including their names, email, date of birth, and profile picture.)

[//]: # (- The "Post" entity represents the posts or content shared by users on the platform. Each post is associated with a specific user and contains textual content.)

[//]: # (- The "Shares" entity represents instances where users share or repost content created by other users. It records the relationship between the sharing user, the post being shared, and the time of the share.)

[//]: # (- The "UserProfile" entity stores additional information about a user's profile. This may include a user's bio or description. It is linked to the respective user using the username as a foreign key.)

[//]: # (- The "Following" entity represents the relationship between users on the social network platform. It records who is following whom and when this relationship was established.)

[//]: # ()
[//]: # (![image]&#40;https://github.com/Mariam-Katamashvili/SocialNetwork/assets/127763064/2e0dc3ef-62e8-4bf7-a5dd-8d31cbb8cec6&#41;)

## Getting Started

To set up and run this application, follow these steps:

1. Clone the repository: 
- git clone https://github.com/Mariam-Katamashvili/SocialNetwork
 
2. Set up the database:
- Install and configure MySQL.
- Create a database and update the `application.properties` file with the database connection details.

3. Build and run the application:
- Build the project using your preferred Java IDE or Maven.
- Run the application.

4. Access the application:
- Open a web browser and navigate to `http://localhost:8080`.

5. Register as a new user, and you're ready to explore the social network!

## Tech Stack

- **Spring Framework**: This project uses Spring Boot for building the web application.
- **MySQL**: The database management system used to store user data, posts, and other related information.

## Contributing

Contributions to this project are welcome. To contribute, please follow these steps:

1. Fork the repository to your own GitHub account.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test them thoroughly.
4. Create a pull request with a clear description of your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Spring and MySQL communities for providing excellent tools and documentation.
- Inspiration for this project comes from the fact that I have a homework to do at EPAM :)

Feel free to reach out with any questions or suggestions. Happy coding!
