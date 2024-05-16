package orimeister.projects.systerm_reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class CpuController {
    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 1500)
    public void sendCpuData() {
        CpuInfo cpuInfo = CpuInfoUtil.getCpuInfo();
        template.convertAndSend("/topic/cpu", cpuInfo);
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }
}
