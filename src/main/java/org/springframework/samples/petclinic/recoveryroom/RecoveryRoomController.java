package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recoveryroom")
public class RecoveryRoomController {
    @Autowired
    RecoveryRoomService recoveryRoomService;

    private final static String CREATE_RECOVERY_ROOM= "recoveryroom/createOrUpdateRecoveryRoomForm";


    @GetMapping("/create")
    public String createARecoveryRoom(ModelMap model){
        model.addAttribute("recoveryRoom", new RecoveryRoom());
        model.addAttribute("types", recoveryRoomService.getAllRecoveryRoomTypes());
        return CREATE_RECOVERY_ROOM;
    }


    @PostMapping("/create")
    public String processCreateARecoveryRoom(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("recoveyRoom", recoveryRoom);
            model.addAttribute("types", recoveryRoomService.getAllRecoveryRoomTypes() );
            return CREATE_RECOVERY_ROOM;
        }else{
            recoveryRoomService.save(recoveryRoom);
            model.addAttribute("message", "Recovery Room succesfully saved");
        }


        return "welcome";
    }

}
