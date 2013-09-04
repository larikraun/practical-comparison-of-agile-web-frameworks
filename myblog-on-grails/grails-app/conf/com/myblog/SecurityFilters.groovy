package com.myblog

/**
 * Generated by the Shiro plugin. This filters class protects all URLs
 * via access control by convention.
 */
import org.apache.shiro.SecurityUtils

class SecurityFilters {
	
	def static final nofilteredActions =
	[
	  [controller: "user", action: "(create)"],
	  [controller: "user", action: "(save)"],
	  [controller: "blog", action: "(show)"],
	  [controller: "post", action: "(show)"],
	  [controller: "post", action: "(list)"],
	  [controller: "comment", action: "(save)"],
	  
	]
	
    def filters = {
        all([uri: "/**"])
		    {
		      before =
		      {
		        // Ignore direct views (e.g. the default main index page).
		        if(!controllerName)
		          return true
		
		        // check filter list
		        boolean matched = false
		
		        for(pair in nofilteredActions)
		        {
		          if(pair.controller =~ controllerName && pair.action =~ actionName)
		          {
		            matched = true
		            break
		          }
		        }
		
		        if(matched)
		          return true
		
		          // Access control by convention.
		        accessControl()
		      }
		    } 
		
        
    }
	
}