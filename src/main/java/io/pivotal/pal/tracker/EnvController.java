package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {


    private Map<String, String> env = new HashMap<>();
    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit:NOT SET}") String memoryLimit, @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex, @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr) {
        env.put("PORT" , port );
        env.put("MEMORY_LIMIT" , memoryLimit );
        env.put("CF_INSTANCE_INDEX" , cfInstanceIndex );
        env.put("CF_INSTANCE_ADDR" , cfInstanceAddr );

    }
    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return env;
    }
    //cf set-env pal-tracker port 5555
    //cf set-env pal-tracker MEMORY_LIMIT '100GB'

    //git remote add origin https://github.com/sunitaskjpmc/pal-tracker.git
    //./gradlew cloudNativeDeveloperReviewPipeline -PreviewUrl=http://pal-tracker-zany-lynx.apps.evans.pal.pivotal.io/
    
}
