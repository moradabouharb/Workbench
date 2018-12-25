package ITMFactory.Workbench;
import ITMFactory.Workbench.Model.Enviroment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/api/itm/enviroment")
@CrossOrigin
public class EnviromentController {

    @Autowired
    private EnviromentDao E;

    @PersistenceContext
    private EntityManager em;

    //http://localhost:8080/api/itm/enviroment?all
    @RequestMapping(params = "all",method = RequestMethod.GET, produces = "application/json")
    public List<Enviroment> GetEnviroment(){
        return E.findAll();
    }

    //Get the enviroment status that releated to specific worksession
    //http://localhost:8080/api/itm/enviroment?sessionid=1
    @RequestMapping(params = "sessionid", method = RequestMethod.GET, produces = "application/json")
    public List<Enviroment> GetEnviromentBySessionID(@RequestParam("sessionid") int sessionid ) {
        return E.GetEnviromentStatusbasedonSessionID(sessionid);
    }

    //Get last enviroment status
    //http://localhost:8080/api/itm/enviroment?last
    @RequestMapping(params = "last", method = RequestMethod.GET, produces = "application/json")
    public List<Enviroment> GetEnviromentBySessionID() {
        return E.GetlastEnviromentStatus();
    }
}
