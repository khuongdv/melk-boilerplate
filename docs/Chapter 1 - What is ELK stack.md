## What is ELK stack
![ELK Stack](https://github.com/khuongdv/melk-boilerplate/blob/master/imgs/what-is-elk2.jpg?raw=true "ELK Stack")

- ELK stack is download 500K times per month
- Most popular log management platform
- ELK stack is a collection of 3 opensource products: [ElasticSearch](http://logz.io/category/blog/elasticsearch/), [LogStash](http://logz.io/category/blog/logstash/), [Kibana](http://logz.io/category/blog/kibana/) from [Elastic](https://www.elastic.co/)
- ElasticSearch is a NoSQL DB that is based on Lucene search engine
- Logstash is a log pipeline tool that accepts inputs from various sources, executes different transformations and exports the data to various targets.
- Kibana is a visualization layer that works on top of ElasticSearch
- These 3 different opensource products are most commonly used in Log analysis in IT env.
- Logstash collects and parse logs, and then ElasticSearch indexes and stores the information. Kibana then presents the data in visualizations that provide actionable insights into one's env
### Why ELK popular
![Chart](https://github.com/khuongdv/melk-boilerplate/blob/master/imgs/what-is-elk-stack.jpg?raw=true "Chart")
- ELK Stack fulfills a need in the log analytics space
- ELK stack is simple but robust log analysis platform
- IT organizations are favoring open source products in general
- ELK stack is adopted by Netflix, Facebook, Microsoft, LinkedIn and Cisco
### Why log analysis becoming more important
- More IT infras move to public clouds (AWS, azure, ect.) so cloud security tools and log analytics platforms are becoming more critical
- Log Management platforms can monitor all infras issues as well ass process OS logs, server logs, app logs, web traffic analysis...
