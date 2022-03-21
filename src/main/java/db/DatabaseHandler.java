package db;

import java.sql.*;

public class DatabaseHandler {
    PreparedStatement pr = null;

    public  static Connection databaseConnect(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/db_formation";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connexion établie.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erreur de connexion !");
            e.printStackTrace();
            e.getCause();
        }
        return con;
    }
    public boolean login(Connection cn,User user)
    {
        boolean state=false;
        try {
            pr = cn.prepareStatement("select count(1) from utilisateur where login = '" + user.getLogin() + "' and password = '" + user.getPassword() + "'");
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
              if(rs.getInt(1)==1){
                state= true;

              }
              else {
                 state=false;

              }
            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return state;
    }

    public void addUser(Connection cn, User user) {
        /*sc = new Scanner(System.in);
        System.out.println("Entrez le matricule : ");
        int eid = sc.nextInt();
        System.out.println("Entrez le nom : ");
        String en = sc.next();
        System.out.println("Entrez le prénom : ");
        String ep = sc.next();
        System.out.println("Entrez la date : ");
        String ed = sc.next();
        System.out.println("Entrez la ville : ");
        String ev = sc.next();
        System.out.println("Entrez le salaire : ");
        int es = sc.nextInt();*/
        try {
            pr = cn.prepareStatement("insert into utilisateur(login,password,role) values(?,?,?)");
            // pr.setInt(1, eid);
            pr.setString(1, user.getLogin());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getRole());
            pr.executeUpdate();
            System.out.println("L'utilisateur a été ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Opération échouée !");
        }
    }

}
