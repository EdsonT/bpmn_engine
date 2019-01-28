package Processes

import com.bpmnengine.BpmnEngineApp
import com.bpmnengine.business_logic.ProcessService
import org.camunda.bpm.engine.RepositoryService
import org.springframework.beans.factory.annotation.Autowired

import spock.lang.Specification

class BaseSpec extends Specification{
    @Autowired
    ProcessService processService
    def "start shared repository"(){
    }
    def cleanupSpec(){
    }

}
