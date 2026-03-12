//=============== Entity Class - Encapsulation ===========================
class Login
{
    private String username;
    private String password;
    private String emailid;
    private long mobileno;

    Login(String username, String password, String emailid, long mobileno)
    {
        this.username = username;
        this.password = password;
        this.mobileno = mobileno;
        this.emailid = emailid;
    }

    void setUsername(String uname)
    {
        username = uname;
    }
    String getUsername()
    {
        return username;
    }

    void setPassword(String pass)
    {
        password = pass;
    }
    String getPassword()
    {
        return password;
    }

    void setEmailid(String email)
    {
        emailid = email;
    }
    String getEmailid()
    {
        return emailid;
    }

    void setMobileno(long mno)
    {
        mobileno = mno;
    }
    long getMobileno()
    {
        return mobileno;
    }
}
