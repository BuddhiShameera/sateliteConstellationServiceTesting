package iit.cloudcopmuting.constellation.response;

public class Response {
	// General
		public static final int SUCCESS = 0;
		public static final int ERROR = -1;
		public static final int PRIMARY_KEY_VIOLATION = -2;
		public static final int DATA_INTEGRITY_VIOLATION = -3;
		public static final int DISABLED = -4;
		public static final int DATA_CHANGE_DETECTED = -5;
		public static final int DATA_ALREADY_EXISTS  = -6;
		public static final int DATA_ALREADY_DELETED = -7;
		public static final int REF_DATA_IN_USE		 = -8;
		public static final int INVALID_OPERATION	 = -9;
		public static final int TASK_CREATION_FAILED = -10;
		public static final int MAX_LENGTH_EXCEEDED  = -11;
		public static final int NIC_ALREADY_IN_USE	 = -12;	
		public static final int NO_TASK_FOUND		 = -13;
		public static final int NO_REMINDER_FOUND	 = -14;
		public static final int NO_DATA_FOUND		 = -15;
		public static final int NO_UPDATE_OCCURRED	 = -16; 
		public static final int SUBORDINATE_NUMBER_NOT_FOUND = -17;
		public static final int NO_DELETE_OCCURRED	 = -18; 
		public static final int UNACCEPTABLE_PAYLOAD	 = -19; 
		public static final int NOT_MODIFIED	 = -20;
		public static final int TOKEN_EXPIRED = -21;
		public static final int MANDATORY_DATA_MISSING = -22;
		
		
		private int id;
		private String status;
		private String description;
		private String token;
		private boolean activeStatus;

		public Response() {
			
		}

		public Response(int id, String status, String description) {
			super();
			this.id = id;
			this.status = status;
			this.description = description;
		}

		public Response(int id, String status, String description, String token) {
			super();
			this.id = id;
			this.status = status;
			this.description = description;
			this.token = token;
		}


		public Response(int id, String status, String description, boolean activeStatus) {
			this.id = id;
			this.status = status;
			this.description = description;
			this.activeStatus = activeStatus;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public boolean isActiveStatus() {
			return activeStatus;
		}

		public void setActiveStatus(boolean activeStatus) {
			this.activeStatus = activeStatus;
		}
}
