package miracle.workWithSql.demo;

import lombok.Cleanup;
import miracle.model.User;
import miracle.workWithSql.config.Database;
import miracle.workWithSql.dao.LaptopsDao;
import miracle.workWithSql.dao.impl.LaptopsDaoImpl;
import miracle.workWithSql.model.Laptop;
import miracle.workWithSql.model.Role;
import miracle.workWithSql.model.TShirts;
import miracle.workWithSql.model.UserRole;
import miracle.workWithSql.service.*;
import miracle.workWithSql.service.impl.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {


        /*UserRoleService userRoleService = new UserRoleServiceImpl();
        System.out.println(userRoleService.getAllUserRole());

        UserRole userRole = new UserRole();
        userRole.setUserId(5);
        userRole.setRoleId(5);
        userRoleService.save(userRole);*/


//        Work with role
//*****************************************************************************************
        RoleService roleService = new RoleServiceImpl();
        System.out.println(roleService.getAllRoles());

        /*Role role = new Role();
        role.setName("Manager");
        roleService.save(role);*/

//        roleService.delete(3);

        Role role = new Role();
        role.setName("HR");
        role.setId(2);
        roleService.update(role);
//***************************************************************************************




//        Work with T-Shirts
//******************************************************************************************
       /* TshirtService tshirtService = new ThirtServiceImpl();
        System.out.println(tshirtService.getAllTshirts());*/

        /*TShirts tShirts = new TShirts();
        tShirts.setColor("Blue");
        tShirts.setSize("xxl");
        tshirtService.save(tShirts);*/

//        tshirtService.delete(6);

     /*   TShirts tShirts = new TShirts();
        tShirts.setColor("Blue");
        tShirts.setSize("xl");
        tShirts.setId(3);
        tshirtService.update(tShirts);*/
//****************************************************************************************




//                  Work with laptop
//***************************************************************************************
      /*  LaptopService laptopService = new LaptopServiceImpl();
        System.out.println(laptopService.getAllUsers());
*/
       /* Laptop laptop = new Laptop();
        laptop.setName("Acer");
        laptop.setUserId(3);
        laptopService.save(laptop);*/

//        laptopService.delete(4);

     /*   Laptop laptop = new Laptop();
        laptop.setName("Lenovo");
        laptop.setUserId(2);
        laptop.setId(3);
        laptopService.update(laptop);*/
//***************************************************************************************



//                      Work with User
// **************************************************************************************
        /*UserService userService = new UserSrviceImpl();
        System.out.println(userService.getAllUsers());*/

       /* miracle.workWithSql.model.User user = new miracle.workWithSql.model.User();
        user.setName("miki");
        user.setSkills("noob");
        userService.save(user);

        userService.delete(13);*/

//       userService.updateUserName(12, "Lola");

//        userService.updateUserSkills(12, "CSS");

      /*  miracle.workWithSql.model.User user = new miracle.workWithSql.model.User();
        user.setName("Lenox");
        user.setSkills("Box");
        user.setId(14);
        userService.updateUser(user);*/

//        statement.execute("INSERT INTO miracle.users (name, skills) VALUES ('Test', 'test test')");

//        statement.executeUpdate("UPDATE miracle.users SET name = 'bob' WHERE id = 4");

//        statement.executeUpdate("DELETE FROM miracle.users WHERE name = 'bob'");
//****************************************************************************************

    }
}
