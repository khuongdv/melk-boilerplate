## Logstash tutorial
![Logstash](https://raw.githubusercontent.com/khuongdv/melk-boilerplate/master/imgs/logstash-tutorial.png "Logstash")
- Logstash stands between source data and Elasticsearch

### How to install Logstash
- Requirement: Java 7 or higher
- All you need next is a Logstash bundle or install from a package manager of our OS

### How to config Logstash
#### Logstash Input
- Can source logs and events from various sources

#### Logstash outputs
- Store to Files, CSV, S3. convert to RabbitMQ message...

#### Logstash filters

### A Logstash config example
#### Structure
A configuration will generally have three sections: inputs, outputs, filters.

The input section tells Logstash to pull logs from the Apache access log and specify the type of those events as apache-access. Setting the type is important, as it will be used to selectively apply filters and outputs later on in the event’s lifetime. It’s also used to organize the events when it’s eventually pushed to Elasticsearch.

In the filter section, we specifically apply a grok filter to events that have the apache-access type. This conditional ensures that only the apache-access events get filtered. If it is not there, Logstash will attempt to apply the grok filter to events from other inputs as well. This filter parses the log string and populates the event with the relevant information from the Apache logs.

Lastly, we see the output section. The first conditional ensures, once again, that we only operate on the apache-access events. The next, nested, conditional sends all of the events that didn’t match our grok pattern to the null output. Since they didn’t conform to the specified pattern, we assume that they are log lines that contain information we’re not interested in and discard it. Since order is important in filters and outputs, this will ensure that only events that were successfully parsed will make it to the Elasticsearch output.

### Working with Logstash Plugins
- Plugins are managed by __bin/plugin__.
- We need to crate a config file and then specify pipeline in there. When start logstash, specify the file path.