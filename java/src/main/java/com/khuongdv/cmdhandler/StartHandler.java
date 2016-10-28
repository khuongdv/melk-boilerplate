package com.khuongdv.cmdhandler;

import com.khuongdv.exception.MyException;
import org.apache.log4j.Logger;

import static com.khuongdv.utils.DataUtils.isStringEmpty;

/**
 * Created by KhuongDV on 10/28/2016.
 */
public class StartHandler implements ICommandHandler {
    public static Logger log = Logger.getLogger(StartHandler.class);

    /**
     * Check ELASTICSEARCH_HOME, LOGSTASH_HOME, KIBANA_HOME
     */
    @Override
    public void preProcess() throws MyException {
        String elasticsearchHome = System.getenv("ELASTICSEARCH_HOME");
        if (isStringEmpty(elasticsearchHome)) {
            throw new MyException("Elasticsearch home not defined", "NOK");
        }
        String logstashHome = System.getenv("LOGSTASH_HOME");
        if (isStringEmpty(logstashHome)) {
            throw new MyException("Logstash home not defined", "NOK");
        }
        String kibanaHome = System.getenv("KIBANA_HOME");
        if (isStringEmpty(kibanaHome)) {
            throw new MyException("Kibana home not defined", "NOK");
        }
    }

    /**
     * Here read configuration for all ELK members, validate and then start each
     */
    @Override
    public void process() {
        startElasticSearch();
        startLogstash();
        startKibana();
    }

    private void startKibana() {
        
    }

    private void startLogstash() {
        
    }

    private void startElasticSearch() {
        
    }

    @Override
    public void postProcess() {

    }

    @Override
    public void template() {
        try {
            preProcess();
        } catch (MyException e) {
            log.error(e.getMessage());
            OUT.println(e.getMessage());
            return;
        }
        process();
        postProcess();
    }
}
