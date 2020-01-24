# Web Crawler for JavaScript libraries
Java program to count top JavaScript libraries found in web pages of Google search result

# Libraries used

- jsoup -> to parse the web page
- JUnit -> for testing

# Approach

1. Parse the first page of search result from a Google search, then collect all the main result links
2. Obtain all the names of JavaScript libraries from all links
3. Clean the names to prevent duplicates. e.g. "/js/jQuery.js?ver=1.0.0" and "/folder1/js/jQuery.js"
4. Store them in a map with their frequency as the values
5. Sort them by frequency
