package Movie.Booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class Main {
    @GetMapping("/")
    public String movie(){return "movie";}
    @GetMapping("/ticket")
    public String ticket(Model model) throws SQLException {
        Database db = new Database();
        List<Map<String, String>> users = db.GetAllUser();
        model.addAttribute("users", users);
        return "ticket";
    }
    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable String id, RedirectAttributes redirectAttributes) throws SQLException {
        System.out.println("Deleting ID = " + id);
        Database db = new Database();
        db.DelTicket(id);
        return "redirect:/ticket";
    }
    @PostMapping("/movie")
    public String Postmovie(
            @RequestParam String movie,
            @RequestParam String seat,
            @RequestParam String members,
            RedirectAttributes redirectAttributes
    )throws SQLException{
        Database db= new Database();
        int result =db.AddTicket(movie,seat,members);

        if (result == 1) {
            return "redirect:/ticket";
        } else {
            return "redirect:/movie";
        }
    }
    
}
