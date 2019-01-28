package Processes

class DeployProcess extends BaseSpec{
    def "Deploy a brand new process"(){
        given:"there is a request to deploy a new process"
        when:"the request is processed"
        then:"the process is deployed within the engine"
    }
}
