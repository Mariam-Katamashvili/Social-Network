# Social Network

This is a social networking web application developed using the Spring framework and MySQL as the database system. The primary goal of this project is to provide a platform for users to register, follow other users, and create and share text-based posts. Users will have personalized timelines that display their posts and the posts of users they follow.

## Features

### User Registration and Authentication

- Users can create an account by providing a username, email, and password.
- Passwords are securely hashed using bcrypt and stored in the database.
- Users can log in securely using their credentials.
- Password reset and email confirmation functionality is also added for improved user experience.

### Profile Management

- Users can edit their profile information, including their profile picture and bio.
- User profiles will display their followers, followed users, and the posts they've shared.

### Posting and Timeline

- Users can create text-based posts that are shared with their followers.
- Posts will include text content, timestamps, and an option for users to like and comment on them.
- The timeline will display posts from the user and the users they follow.
- Users can search for other users to follow and see their posts in their timeline.


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
- Inspiration for this project comes from the fact that I have a homework to do :)

Feel free to reach out with any questions or suggestions. Happy coding!
