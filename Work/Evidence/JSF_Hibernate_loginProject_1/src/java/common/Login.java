package common;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;    
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
@ManagedBean(name = "login_bean")
@SessionScoped
@Entity
@Table
public class Login implements Serializable {
    @Id
    private int sl_no;
    private String user_name;
    private String password;
    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }
    public int getSl_no() {
        return sl_no;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getPassword() {
        return password;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean checkuser(){
        try {
            System.out.println("user name "+user_name);
            System.out.println("passowrd "+password);
            SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            Query query=session.createQuery("from Login where user_name=:user_name and password=:password");
            query.setString("user_name", user_name);
            query.setString("password", password);
            List list=query.list();
            System.out.println("list size "+list.size());
              if(list.size()==1){
                  return true;
              }else{
                  return false;
              }
        } catch (Exception e) {
            System.out.println(e);
        }
            return false;
    }
    public Login() {
    }
  }
