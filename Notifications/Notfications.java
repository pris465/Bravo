class Notifications{
	/*
		@param emailList[] it will be an array containing all the email addresses the report must be sent to
		@param file this will be the generated report file that needs to be sent as an attachment with the email
	*/
	public void sendReport(String emailList[], String file){
		/*
			This function must take the list of emails and add each one to be sent to, ask buildMessage to generate the appropriate message
			and receive the email's body from buildMessage.

			We are in the process of making a telnet server to interface to the up mail server so just code as far as you can then be able to explain
			the work you have done thus far.
		*/
	}

	/*
		@param emailList[] it will be an array containing all the email addresses the notification must be sent to
		other parameters still unsure
	*/
	public void sendNotification(String emailList[]){
		/*
			The email list must receive their notifications as per request, a sql request must be made to pull the notification message as the user speicifed
			when the notification was created.

			Thus each mail must be sent one by one so each user can get his/her personalised notfication.

			This will not use buildMessage as the user specified his own message.
		*/
		String message = "Sample message"; //this will be replaced with code to fetch the message stored on the database
		String email = "Sample Email" //this will also have been fetched from the database
		
		message = message + "Sent via automatic notifications";
	}

	/*
		@param emailList[] it will be an array containing all the email addresses the change notice must be sent to
		other parameters still unsure
	*/
	public void sendChange(String emailList[], String publicationName){
		/*
			All authors must be notified if someone made changes to their publication of any kind. (Note the publication name must be specified as an author can belong to multiple groups) 
			Still to be figured out if it will tell the authors exactly what was changed. (to be discussed)
		*/
		String message = "";
		
		for (int i = 0; i < emailList.length; i ++){
			if (emailList[i] != null && !emailList[i].isEmpty()){
				message = buildMessage(emailList[i], "Change", publicationName)
				//submitEmail(email_Address, email_subject, email_message)
				submitEmail(emailList[i], "Change in Publication", message);
			}
		}
	}

	/*
		@param emailList[] it will be an array containing all the email addresses the change notice must be sent to
		other parameters still unsure
	*/
	public void sendTextMail(String emailList[]){
		/*
			This will be used to email plain text emails no images/files etc. 
			will use buildMessage to assist the contruction of the message.
		*/
		String recipientList=emailList[0];
		String message="sample message"; //the message to be sent to the recipient
		
		//list of recipients seperated by commas : e.g banele@gmail.com , u12201911@tuks.co.za , mm@webmaster.com
			for (int i=1;i<emailList.length;i++)
			{
				recList+=","+emailList[i];
			}
			
	}

	/*
		@param typeOfRequest specifies the type of request it will be eg a notification or a change notice.
	*/

	/*
		@param clientName this variable specifies the email receiptiant's name to make the mail look more professional may be null;
		@param typeOfRequest specifies the type of request it will be eg a notification or a change notice.
		@param publicationName is the name of the publication that is included in the report or has been changed. This field can be null
	*/
	private String buildMessage(String clientName, String typeOfRequest, String publicationName){ // Frederick
		/*
			This will take the client's name and add it to the message to give it a personal touch
			The type of request will let the function know which template file to use.
		*/
		String message = "";
		
		if((typeOfRequest.equals("Change") && (!publicaionName.equals(""))){
			message = publicationMessage(publicationName);
		}
		else if((typeOfRequest.equals("Notification")) && (!clientName.equals("")){
			message = notificationMessage(clientName);
		}
		else if((typeOfRequest.equals("Report")) && (!publicaionName.equals("")){
			message = reportMessage(publicationName);
		}
		else {
			message = "";
		}
		return message;
	}
	
	/*Functions to help mock build message's functionality */

	private String publicationMessage(String publicationName){
		String intro = "To whom it may concern \n";
		String body = "Please note that the following publication has been modified:";
		String salutation = "Regards \n Bravo team"
		String completed = intro + body + publicationName + "\n" + salutation;
		return completed;
	}

	private String notificationMessage(String clientName){
		String intro = "Dear " + clientName + "\n";				// sql request to sql database to get notification message
		String body = "This is the user's personal message";
		String salutation = "Regards \n Bravo team"
		String completed = intro + body + "\n" + salutation;
		return completed;
	}

	private String reportMessage(Srting publicationName){
		String intro = "To whom it may concern \n";				// sql request to sql database to get the report file
		String body = "Plesae find attached the report file for: ";
		String salutation = "Regards \n Bravo team"
		String completed = intro + body + publicationName + "\n" + salutation;
		return completed;

		//message = clientName + ", \n" + typeOfRequest;
		
		//return message;
	}
	

}
