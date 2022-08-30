package com.team3.bookmanagement.dto;


public class UserDTO {

		private Long id;

		private String username;

		private String password;

		private String email;
	
		private String avatarUrl;
		
		

		public UserDTO(Long id,String username, String password,
				String email, String avatarUrl) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.avatarUrl = avatarUrl;
		}
		
		
		public UserDTO() {
			super();
		}


		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String userName) {
			this.username = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAvatarUrl() {
			return avatarUrl;
		}
		public void setAvatarUrl(String avatarUrl) {
			this.avatarUrl = avatarUrl;
		}
		
}
