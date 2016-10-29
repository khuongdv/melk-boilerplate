# melk-boilerplate
Boilerplate building an app use Elastic Search Engine, MongoDB, LogStash, Kibana to index and visualize data

## Summary
  - Creator: Khuong Dao (khuongdv@github)
  - Purpose:
    - In short, there are 3 challenges in log analysis:
      1. Non-consitent log format
        - Content variation
        - Date format variation
      2. Decentralized logs
        - Logs spread across all the applications that maybe across different servers/components
      3. Expert knowledge requirement (for reading log in terminal or text editor)
    - ELK Stack solves above issues, built on top of Elasticsearch, Logstash and Kibana
      1. Elasticsearch: 
        Distributed search engine based on Apache Lucene
        Provides horizontal scalability
        Features available through JSON over a Restful API
      2. Logstash: 
        A data pipeline that helps collect, parse, and analyze a large variety of structured and unstructured data and events from various systems
        Centralized data processing, support for custom log formats, plugin development        
          - Provides plugins to connect to various types of input sources and platforms
          - Provides plugins to transform data          
          - Provides plugins to output data to various type
      3. Kibana: A visualization platform
        - It provides flexible analytics and a visualization platform for business intelligence.
        - It provides real-time analysis, summarization, charting, and debugging capabilities.
        - It provides an intuitive and user friendly interface, which is highly customizable through some drag and drop features and alignments as and when needed.
        - It allows saving the dashboard, and managing more than one dashboard. Dashboards can be easily shared and embedded within different systems.
        - It allows sharing snapshots of logs that you have already searched through, and isolates multiple problem transactions

## Target
  - To provide documentation of ELK Stack
  - To write a CLI to setup an ELK Stack
  - (In future, maybe support clustering elasticsearch and turn performance)
## Current progress: 
  - Learn how to use elasticsearch, logstash and kibana first. View [this file](https://github.com/khuongdv/melk-boilerplate/blob/master/elk-guide.md).

  - Writing java application, source code in ```java``` directory
