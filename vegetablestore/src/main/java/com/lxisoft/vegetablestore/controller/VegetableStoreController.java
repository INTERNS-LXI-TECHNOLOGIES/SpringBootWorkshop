package com.lxisoft.vegetablestore.controller;


import com.lxisoft.vegetablestore.dao.VegetableDao;
import com.lxisoft.vegetablestore.vegetable.Vegetable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Controller
@MultipartConfig
public class VegetableStoreController {

VegetableDao vegetableDao = new VegetableDao();


@GetMapping("/")
public String readVegetable(Model model) throws IOException {

    model.addAttribute("vegetable",vegetableDao.readVegetable());
    return "vegetable";
    }


@GetMapping("/add-form")
public String addVegetableForm(){

return "addVegetable";
}


@PostMapping("/create-vegetable")
public String createVegetable(@ModelAttribute Vegetable vegetable){

try {
    vegetableDao.addVegetable(vegetable);

}catch(Exception e){

}
    return "vegetableConfirm";
}


@GetMapping("/select-vegetable")
public String selectVegetable(@RequestParam("id")int id,Model model) {

        model.addAttribute("vegetable",vegetableDao.selectData(id));

    return "updateVegetable";
}



@PostMapping("/update-vegetable")
    public String updateVegetable(@ModelAttribute Vegetable vegetable) throws IOException {

            vegetableDao.updateVegetable(vegetable);

return"redirect:/";
    }



@PostMapping("/delete-vegetable")
public String delete(@RequestParam("id")int id) {

        vegetableDao.deleteVegetable(id);

return "redirect:/";
}




@GetMapping("/search")
public String search(@RequestParam("search")String word,Model model){

        model.addAttribute("vegetable", vegetableDao.search(word));

return "vegetable";
}




@GetMapping("/image")
public void image(@RequestParam("name")String name, HttpServletResponse response) throws IOException {

    String path ="../../../vegetablestore/src/main/resources/picture/"+ name;

    byte [] image = getImageAsBytes(path);

    response.setContentType("image/jpeg");
    response.setContentLength(image.length);
    response.getOutputStream().write(image);


}

    private byte[] getImageAsBytes(String name) {


        File imgPath = new File(name);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            BufferedImage bufferedImage = ImageIO.read(imgPath);
            ImageIO.write(bufferedImage, "jpg", bos );
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();

    }

    @GetMapping("/log-out")
public String logOut(HttpServletRequest request){

    HttpSession session = request.getSession();
    session.invalidate();

        return "redirect:/";
}


}

