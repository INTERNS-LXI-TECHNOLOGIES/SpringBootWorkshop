package com.example.library.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import com.example.library.dto.UserDto;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private BookRepository bookRepository;
	
	@Override
	public UserDto addUser(UserDto userDto) {
		User user = new User();
        mapDtoToEntity(userDto, user);
        User savedUser = userRepository.save(user);
        return mapEntityToDto(savedUser);
	}

	@Override
	public List<UserDto> getAllUser() {
		 List<UserDto> userDtos = new ArrayList<>();
	        List<User> users = userRepository.findAll();
	        users.stream().forEach(user -> {
	        	UserDto userDto = mapEntityToDto(user);
	        	userDtos.add(userDto);
	        });
	        return userDtos;
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto user) {
		User usr = userRepository.getOne(userId);
		usr.getBooks().clear();
        mapDtoToEntity(user, usr);
        User userr = userRepository.save(usr);
        return mapEntityToDto(userr);
	}

	@Override
	public String deleteUser(Integer userId) {
		User user = userRepository.getOne(userId);
        //Remove the related books from user entity.
		user.removeBooks();
        userRepository.deleteById(userId);
        return "Student with id: " + userId + " deleted successfully!";
	}

	
	private void mapDtoToEntity(UserDto userDto, User user) {
		user.setName(userDto.getName());
        if (null == user.getBooks()) {
        	user.setBooks(new HashSet<>());
        }
        userDto.getBooks().stream().forEach(bookName -> {
            Book book = bookRepository.findByName(bookName);
            if (null == book) {
            	book = new Book(bookName, bookName, null);
            	book.setUsers(new HashSet<>());
            }
            book.setName(bookName);
            user.addBook(book);
        });
    }
 
    private UserDto mapEntityToDto(User user) {
    	UserDto responseDto = new UserDto();
        responseDto.setName(user.getName());
        responseDto.setBooks(user.getBooks().stream().map(Book::getName).collect(Collectors.toSet()));
        return responseDto;
    }
	
}
