package org.danielli.xultimate.crawler2.support.urlresolver;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class RestTemplateAbstractUrlResolver extends AbstractUrlResolver {

	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;
	
	@Override
	public void handle(String linkId, String linkUrl) throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity(linkUrl, String.class);
		handle(response, linkId, linkUrl);
	}
	
	public abstract void handle(ResponseEntity<String> response, String linkId, String linkUrl) throws Exception;
}