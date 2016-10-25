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
## An Elasticsearch tutorial
![Elasticsearch tut](https://raw.githubusercontent.com/khuongdv/melk-boilerplate/master/imgs/elasticsearch-tutorial.png "Elasticsearch tut")
- Elasticsearch often know as a search server, but it is a NoSQL Database (it stores data in a unstructured way)
### How to install Elastic Search
- Requires: Java 7 or higher, Must have supported OS in [this list](https://www.elastic.co/support/matrix)
- We can download standalone elasticsearch or use YUM/APT commands
- For now, download the distribution (standalone elasticsearch), extract it to a directory. We can start Elasticsearch by running __bin/elasticsearch__
- Go to __http://127.0.0.1:9200__ to verify that Elasticsearch properly runs, below is a sample output:
```
{
 "name" : "Bloodhawk",
 "cluster_name" : "elasticsearch",
 "version" : {
 "number" : "2.1.1",
 "build_hash" : "40e2c53a6b6c2972b3d13846e450e66f4375bd71",
 "build_timestamp" : "2015-12-15T13:05:55Z",
 "build_snapshot" : false,
 "lucene_version" : "5.3.1"
 },
 "tagline" : "You Know, for Search"
 }
```
### Creating an index in Elasticsearch
- Adding data to Elasticsearch is called indexing (the data will be placed in Apache Lucene indexes)
- We can add data to Elasticsearch using POST or PUT http requests.
- Use PUT: we have to specify ID for data items, use POST: we want Elasticsearch to generate ID for data items
- Data to be sent is in JSON form
### ElasticSearch query
- Once we have data indexed into Elasticsearch, we can start searching and analyzing it
- Simple case: fetching a single item, use http request with GET method
```
curl -X GET http://127.0.0.1:9200/app/users/4

{
 "_id": "4",
 "_index": "app",
 "_source": {
 "id": 4,
 "last_login": "2015-01-18 12:34:56",
 "username": "john"
 },
 "_type": "users",
 "_version": 1,
 "found": true
 }
```
- In result: Fields with an underscore are meta fields, ___source__ object is the original document that wasindexed
- Use ___search__ endpoint
```
curl -X GET http://127.0.0.1:9200/_search?q=logged
 {
 "_shards": {
 "failed": 0,
 "successful": 10,
 "total": 10
 },
 "hits": {
 "hits": [
 {
 "_id": "AVJWJkaW0D5QbnIxzP5S",
 "_index": "logs",
 "_score": 0.095891505000000002,
 "_source": {
 "admin": false,
 "message": "User logged in",
 "timestamp": "2015-01-18 12:34:56",
 "user_id": 4
 },
 "_type": "my_app"
 }
 ],
 "max_score": 0.095891505000000002,
 "total": 1
 },
 "timed_out": false,
 "took": 62
 }
```
- Some info returned:
    - __took__: The time in milliseconds the search took
    - __timed_out__: if the search timed out
    - __shards__ The number of Lucene shards searched, and their success and failure rates
    - __hits__: the actual results along with meta information for the results
- By providing only a word, all of the fields of all the documents are searched for that word. We can use more complicated query
- Elasticsearch also provides [request body search](https://www.elastic.co/guide/en/elasticsearch/reference/current/search-request-body.html).
    - Mix & match different options to get the results that you require
    - Some of the options are: GEO query, scripted query
- Filter vs query: (Learn more...)
### Removing Elasticsearch data    
- Send a http DELETE request to the index URI
- We can specify the ID in the body, or use a query instead
## ElasticSearch Cluster Setup and Upgrading
![ElasticSearch Cluster Setup and Upgrading](https://raw.githubusercontent.com/khuongdv/melk-boilerplate/master/imgs/elasticsearch-cluster-setup-update.jpg "ElasticSearch Cluster Setup and Upgrading")
- Checklist of tips that DevOps engineers and SysAd need to remember when want to upgrade ElasticSearch clusters:
    - Reading Before your update
    - Planning Your Cluster update
    - Testing your cluster update
## Logstash tutorial
## Kibana tutorial
## Creating Customized Kibana Visualizations
## The Lessons to Learn from Elasticsearch Cluster Disconnects
## How to Avoid and Fix the Top 5 Elasticsearch Mistakes
## 5 Logstash Pitfalls to Avoid
## A Comparison of Fluentd and Logstash
## A Guide to Logstash Plugins
## How to Deploy the ELK Stack in Production
## How to Install the ELK Stack on AWS: A Step-By-Step Guide
## Troubleshooting 5 Common ELK Glitches
## Using the ELK Stack for NGINX or IIS Log Analysis
## How to Use the ELK Stack to Monitor Performance
## Conclusion: The Logz.io Free ELK Apps Library
## Appendix: Our Additional ELK Stack Resources
