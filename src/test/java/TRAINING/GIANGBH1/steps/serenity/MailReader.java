package TRAINING.GIANGBH1.steps.serenity;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import com.sun.mail.pop3.POP3Folder;

public class MailReader {
	public static String account;
	public static String password;

	private Folder inbox;
	public Message messages[];

	public MailReader(String account, String password) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		this.account = account;
		this.password = password;

		/* Set the mail properties */

		/*Properties props = System.getProperties();
		// Set manual Properties
		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.pop3.socketFactory.fallback", "false");
		props.setProperty("mail.pop3.port", "995");
		props.setProperty("mail.pop3.socketFactory.port", "995");
		props.put("mail.pop3.host", "pop.gmail.com");

		try
		{
			/* Create the session and get the store for read the mail. */
			/*Session session = Session.getDefaultInstance(System.getProperties(), null);

			Store store = session.getStore("pop3");

			store.connect("pop.gmail.com", 995, this.account, this.password);

			/* Mention the folder name which you want to read. */
		Properties props = new Properties();
		props.put("mail.pop3.host" , "pop.gmail.com");
		props.put("mail.pop3.user" , MailReader.account);
		// Start SSL connection
		props.put("mail.pop3.socketFactory" , 995 );
		props.put("mail.pop3.socketFactory.class" , "javax.net.ssl.SSLSocketFactory" );
		props.put("mail.pop3.port" , 995);

		Session session = Session.getDefaultInstance(props , new Authenticator() {
		    @Override
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication( MailReader.account , MailReader.password);
		            }
		});
		try {
		    Store store  = session.getStore("pop3");
		    store.connect("pop.gmail.com" , MailReader.account , MailReader.password);
			inbox = store.getFolder("INBOX");
            POP3Folder pfolder = null;
            if (inbox instanceof POP3Folder){
                pfolder = (POP3Folder)inbox;
            }else{
                System.out.println("NOT AN INSTANCE OF POP3 Folder");
            }
			/* Open the inbox using store. */
			inbox.open(Folder.READ_ONLY);

			/* Get the messages which is unread in the Inbox */
			//this.messages = pfolder.getMessages();
			this.messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.RECENT), false));

			System.out.println("Total: " + this.messages.length);
			//System.out.println("Total2: " + this.messages.length);
			/*System.out.println("Message Count Found " + inbox.getMessageCount());
			System.out.println("Message Count Found " + inbox.getMessageCount());
			System.out.println("New Message Count " + inbox.getNewMessageCount());
			System.out.println("New Message Count " + inbox.getNewMessageCount());
			System.out.println("Unread Message Count " + inbox.getUnreadMessageCount());
			System.out.println("Unread Message Count " + inbox.getUnreadMessageCount());*/
		}

		catch (MessagingException e) {
			System.out.println("Exception while connecting to server: " + e.getLocalizedMessage());
			e.printStackTrace();
			System.exit(2);
		}

	}

	public int TotalNewMessage() throws MessagingException {
		/* Get the messages which is unread in the Inbox */
		return this.messages.length;
	}

	public String GetEmailSubject(int index) throws MessagingException {
		if (this.messages.length > index) {
			Message msg = this.messages[index];
			return msg.getSubject();
		} else {
			return "The index must be less than total of email";
		}

	}

	public String GetEmailBody(int index) throws IOException, MessagingException {
		if (this.messages.length > index) {
			Message msg = this.messages[index];
			return msg.getContent().toString();
		} else {
			return "The index must be less than total of email";
		}
	}

	public void printAllMessages(Message[] msgs) throws Exception {
		for (int i = 0; i < msgs.length; i++) {
			System.out.println("MESSAGE #" + (i + 1) + ":");
			printEnvelope(msgs[i]);
		}

	}

	public void printEnvelope(Message message) throws Exception

	{
		Address[] a;

		// FROM
		if ((a = message.getFrom()) != null) {
			for (int j = 0; j < a.length; j++) {
				System.out.println("FROM: " + a[j].toString());
			}
		}
		// TO
		if ((a = message.getRecipients(Message.RecipientType.TO)) != null) {
			for (int j = 0; j < a.length; j++) {
				System.out.println("TO: " + a[j].toString());
			}
		}
		String subject = message.getSubject();

		Date receivedDate = message.getReceivedDate();
		Date sentDate = message.getSentDate(); // receivedDate is returning
												// null. So used getSentDate()

		String content = message.getContent().toString();
		System.out.println("Subject : " + subject);
		if (receivedDate != null) {
			System.out.println("Received Date : " + receivedDate.toString());
		}
		System.out.println("Sent Date : " + sentDate.toString());
		System.out.println("Content : " + content);

		getContent(message);

	}

	public String getContent(Message msg)
	{
		try {
			String contentType = msg.getContentType();
			System.out.println("Content Type : " + contentType);
			if(contentType.startsWith("multipart/alternative"))
			{
				Multipart mp = (Multipart) msg.getContent();
				int count = mp.getCount();
				return dumpPart(mp.getBodyPart(count - 1));
			}
			else
			{
				return msg.getContent().toString();
			}
		} catch (Exception ex) {
			System.out.println("Exception arise at get Content");
			ex.printStackTrace();
			return "";
		}
	}

	public String dumpPart(Part p) throws Exception {
		// Dump input stream ..
		InputStream is = p.getInputStream();
		// If "is" is not already buffered, wrap a BufferedInputStream
		// around it.
		if (!(is instanceof BufferedInputStream)) {
			is = new BufferedInputStream(is);
		}
		int c;
		String content="";
		while ((c = is.read()) != -1) {
			content += (char) c;
		}
		return content;
	}
}
