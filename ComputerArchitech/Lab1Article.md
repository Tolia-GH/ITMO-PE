# Principles of Internet censorship and solutions

## 1. Introduction

We are living in a society with highly developed Internet technology, and this kind of technology gives us freedom to do almost anything. We can obtain, publish and spread different kinds of information between races, regions and countries. 

However, this kind of freedom may also lead to some sort of social preblems, like rumors, cyberbullying, pornography(even including child), etc. 

For example, The Nth Room Case[^1] that happened in Korea, about 260,000 people participated in sexual crimes to 76 women(including 16 underage girls), on Telegram. 

And one more example from my personal experiensce, when I was a freshman in university, I once received a message from a man called Daniil Ukraintsev on Vk written in Chinese like this.

![](./Lab1Article-1.jpg)

He said a lot of a lot of rumors that insulted my government and my country. I can't stand his nonsense anymore so I asked him to shut up. 

He is not the only one. As a matter of fact, there has been such a group on the Internet spreading all kinds of fabricated rumors and try to divide our government and our nation. Many of my friends have been harassed by such people on the Internet. 

The examples I listed above are just the tip of the iceberg among the many social problems caused by the freedom given by Internet technology.

So, what I want to say is that the real freedom should be caged by limits. Like Rousseau said: Every one is born to be free, but everywhere he is in chains. And the limit of Internet is what we called Internet Censorship.

But somehow these limits also lead to many incovenience to us. While Internet censorship limits this uncontrolled freedom, It has also increased the difficulty in obtaining information, Influenced the spread of information and knowledge, and limited the use of internet service. Especially as a open source developer. I can't even normally use GitHub in China. So sometimes we need to find a way to break through this limitation. In order to do this, first thing we need to do is to understand the technical principles involved behind Internet Cnesorship.

## 2. Principle

### Web Browsing

Now let us learn about the proccess of web browsing. What exactly happened after we input a URL to our web broswer? Here is a flow chart that explain it.

![](./Lab1Article-2.png)

Basically there are 8 steps in the Proccess of Web browsing:

1. Input URL
2. Resolve DNS
3. Build TCP link
4. Send Http request to Web server
5. Web server handle request
6. Send Http response to browser
7. Render page
8. Show Page

After we input a URL to our web browser, we need to get the IP address of domain in URL. We will first search the local hosts file in our computer which store the mapping relationship between domain names and IP addresses. If we can't find it, then we will ask the outer Domain server for IP address. After we get the IP address, we will try to make TCP connection and send Http request to the Web server. The Web server will handle the request and then send Http response to browser. Then the browser will get the response, and analyze other files referenced by HTML in response and automatically send more requests. After all the resources is given by Web server. The web page will be rendered and shown on our browser.

Now we know the proccess of Web browsing, how can we block a user from accessing web pages normally?

### URL Filtering

We can add a URL filtering system after the first step of web browsing proccess.

The basic working process of URL filtering is to check the URL address requested by the user, compare the information with the URL database or URL list, and execute the corresponding response action (allow/reject) if it matches a certain URL. If the URL that the user accesses is prohibited, the URL filtering system will block the user's request and return an error page to the user or redirect to a specified page to notify the user that the page accessed is denied. 

The URL database or list can be stored locally on the device or in the cloud. Generally, frequently accessed URLs are cached locally, and more URLs are stored in the cloud. When performing URL filtering, in order to minimize network latency, the system first will searche in the local cache, and then will searche in the cloud when the URL is not matched.

In addition, there are many ways to organize URL databases or URL lists, including URL classification, single URL blacklist, and single URL whitelist. The detailed URL filtering process is as follows.

![]()

### DNS Hijacking

Also, we can block the web access in the proccess of domain resolving by hijacking the domain name server. In order to do so, we need to know what is Domain Name System(DNS), and how does it works.

Here is the organizational structure of the domain name:

![]()

As we can see, the domain names are organized in a tree structure.The top of the tree represents the root server. The next level below the root is composed of the well-known general domains such as .com, .net, and .cn and national domains such as .cn and .uk, which are called top-level domains. Next are the third and fourth level domains, and so on.

Now, let's learn about the Proccess of DNS resolution. Since the domain name information is distributed and stored on multiple DNS servers, the search process of domain name information is performed recursively like this

![]()

For example, we send a resolve request of `www.zdns.cn` to Domain Name Server. The Domain name server will send the request to root server, then will get the response and send request to the server of the top level, and then the second level and so on. and finally we got the IP address from the last level, and then begin to link to the Web server.

We can use `dig` command to get the full proccess of DNS resolution, take this as an example:

```
$ dig math.stackexchange.com
```

After inputing the command above, we will get an output like this:

![]()

- The first part is query parameters and statistics.
- The second part is the query content.  
  It shows that querying the address record of the domain name math.stackexchange.com, A is the abbreviation of address.
- The third part is the DNS server's response.  
  It shows that math.stackexchange.com has four address records, that is, four IP addresses. 600 is the TTL value (represent how long it will be stored in cache), which indicates the cache time, that is, no need to re-query in 600 seconds.
- The fourth part shows the NS(Name Server) record of stackexchange.com, that is, which servers are responsible for managing the DNS records of stackexchange.com.
  It shows that there are four NS records for stackexchange.com, that is, four domain name servers. By querying any of them, you can know what the IP address of math.stackexchange.com is.
- The fifth part is the IP address of the above four domain name servers, which is returned together with the previous paragraph.
- The sixth part is some transmission information from the DNS server.
  It shows that the local DNS server is 192.168.1.253, the query port is 53 (the default port of the DNS server), and the response length is 305 bytes.

That is the whole proccess of DNS resolution. Knowing this, we can understand how DNS hijacking block the user from accessing to website.

DNS hijacking interferes with the DNS resolution process. DNS hijackers can use many ways like modify the results of DNS queries or inject wrong mapping relationships in the DNS cache, causing users to be unable to access the target website normally, and be redirected to other websites, or display error messages.

URL过滤和DNS过滤都属于Web过滤，但是控制粒度和实现方式不同。URL过滤是通过提取用户URL请求中URL信息进行过滤，可以控制到网页级别；而DNS过滤是通过提取用户DNS请求中域名信息进行过滤，只能控制到整个域名级别。两者各有应用场景。

例如企业需要禁止员工访问域名为example.news.com的整个网站，就可以选择DNS过滤。但是如果只是想禁止此域名的娱乐版块 example.news.com/entertainment，那么就需要使用URL过滤。

### IP Blocking

After getting the correct IP address, we can still prevent user from accessing to website by using IP Blocking.

Here is an example process in the Firewall:

![]()

When the firewall gets an ip request from browser. The firewall will judge weather this IP address is on the blacklist. If so, then the firewall will drop these requests, preventing them from reaching the target server. If it's not on the blacklist, then it will turn to the keyword filtering system.

### Keyword Filtering

After the connection to Web browser is built, The filtering system will check the content in network traffic, including text content, HTML tags, etc. in HTTP requests and responses and compare the content in network traffic against a keyword list to determine whether sensitive keywords or phrases are included.

There are different algorithms used by keyword filtering:

- String matching algorithm:
Match each word or phrase in the text to the target keyword

- Regular expression matching:
Regular expressions can be used to flexibly match patterns in text, including keywords, phrases, phrases, etc. By constructing appropriate regular expression patterns, detection and filtering of text containing specific keywords can be achieved.

- Machine learning based algorithm:
Using machine learning algorithms can automatically learn the characteristics and contextual information of keywords based on large amounts of training data, thereby achieving more accurate and intelligent keyword filtering.

Keyword filtering can be set on 3 different level:
- router level: Keyword filtering in routers, gateways, and firewalls to identify URLs and data packets can be used to restrict external communication within the intranet
- Server-side filtering of Internet applications such as forums, online games, news comments, blogs, etc., often used to control speech that is pornographic, violent, religious, or other policy requirements
- The network application software itself comes with a keyword list to process the specified keywords.

## 3. Solution

### Hosts file

The hosts file is an operating system file without an extension. It stores the mapping relationship between host names and IP addresses in the form of a table. It has a higher query priority than the DNS server during the DNS resolution process.

Based on these characteristics, we can modify the hosts file and add the mapping relationship between domain names and IP addresses to break through network censorship based on DNS hijacking.

Since there are many other ways to achieve Internet Censorship besides DNS hijacking. Is there any way to breack through all these censorship?

### Proxy Server

We can add a Proxy server to the Internet process as a middleman, forwarding data between the client and the destination server. The working principle of the proxy server can be divided into the following steps:

- Receive request:  
  When a user sends a request in a browser or other web application, the request first reaches the proxy server.
- Parse request:  
  The proxy server parses the user's request, including the requested target address, request method, protocol version and other information.
- Handle request:  
  Depending on the content of the request and the proxy server's configuration, the proxy server may handle it differently:
  - Caching requests: If the proxy server has already cached the same request or response, it can directly return the cached data without requesting the target server again.
  - Filter requests: The proxy server can filter requests based on configured rules, such as blocking access to specific domain names or URLs, blocking the transmission of specific content types, etc.
  - Modify the request: The proxy server can modify the user's request, such as modifying the request header, adding additional information, etc.
- Forward request:  
  The proxy server forwards the processed request to the target server. This process involves establishing a connection to the target server and sending request data to the target server.
- Receive response:  
  After the target server receives the request, it processes the request and generates corresponding response data. The response data is first sent to the proxy server.
- Parse response:  
  The proxy server parses the response data returned by the target server, including the response status code, response header information, response body, etc.
- Handle response:  
  The proxy server processes the response data and its own configuration:  
  - Cache responses: If caching of response data is allowed and the response data can be cached, the proxy server will save the response data in the cache for future use.
  - Filtering responses: According to configured rules, the proxy server can filter out some response data, such as removing advertisements, blocking malicious content, etc.
  - Modify the response: The proxy server can modify the response data returned by the target server, such as adding additional response headers, modifying the response content, etc.
- Return response:
  The processed response data is ultimately returned to the user's browser or application. The data received by the user is actually the result of processing by the proxy server.

Through the above process, the proxy server realizes the role of a middleman between the user and the target server, and can perform various operations on network requests and responses, thus realizing a variety of functions, such as bypass Internet censorship, filtering content, hiding real IP, etc.
​
### VPN

Here is a way by using VPN

VPN (Virtual Private Network) is an encrypted communication channel that allows users to securely access the Internet by establishing an encrypted VPN tunnel between the user device and the VPN server.

![]()

Under normal conditions, when you enter an URL like example.com in the browser, this information will be sent to the protocol stack by the browser and packaged into a Packet and then be sent through the public network. And this is all visible to ISPs, governments, etc. via the real IP address.

By using VPN, the original data packet will be re-packaged by the VPN protocol (such as PPTP, OpenVPN) (the IP header address will become the address of the selected VPN server) and encrypted, and then sent through the virtual network tunnel. In this case No third party can know your specific access URL and behavior.

And Because users are actually connecting and browsing through a VPN server, they can bypass local censorship and blocking restrictions and freely access to blocked content.

## 4. Challenge

### Technical Challenge

The spread of encryption and privacy technologies: The spread of encrypted communications and privacy protection technologies allows users to access the Internet more securely, bypassing censorship and surveillance.

The development of network anonymization tools: The development of network anonymization tools such as Tor and VPN allows users to hide their real IP addresses and bypass geographical restrictions and censorship firewalls.

Application of emerging technologies: The application of emerging technologies, such as blockchain, decentralized technology, etc., may provide new means to bypass censorship and blocking.

### Social Challenge

Invasion of personal privacy: Some way of Internet censorship may involve invasion of personal privacy, such as monitoring and intercepting personal communications, collecting personal data, etc. This may lead to the invasion of personal privacy rights and affect personal freedoms.

Restricted Free Speech: Internet censorship limits people’s ability to freely express their opinions and views on the Internet. This may lead to misalignment of information and affect the public's understanding and judgment of facts.

Isolation of cyberspace: Internet censorship may lead to the division and isolation of cyberspace, making it impossible for people in different regions to share the same information resources and network services. This may exacerbate information gaps and social divisions between regions.

[^1]: [The Nth Room Case](https://en.wikipedia.org/wiki/Nth_Room_case)