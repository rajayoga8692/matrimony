(function(angular) {  
"use strict";  
 angular.module("mtyApp",['ngRoute','oc.lazyLoad','data-provider','ui.bootstrap','cgBusy','angularUtils.directives.dirPagination','DASHBOARD-CTRL','VIEWPROFILE-CTRL','VIEWPROFILE-PRINTCTRL','PLAN-CTRL','DISTRICT-CTRL','SUBCASTE-CTRL','MENU-CTRL','REGISTRATION-CTRL','ADMIN-CTRL','SEARCH-CTRL','CONTACT-CTRL','MEMBERVIEWHIS-CTRL','COUNTRY-CTRL','JOB-CTRL','WORKPLACE-CTRL','RESIDENCE-CTRL','REPORT-CTRL']).config(function($routeProvider) { 
	  $routeProvider.when('/', {templateUrl: './app/views/dashboard.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['./assets/js/index.min.js'] 
	                },
	                {
	                    serie: true,
 	                    files: ['./assets/js/plugins/parallax-slider.js']
	                } 
	                              
	            ]);
	      	}
	        }
		  });  
	  $routeProvider.when('/registration', {templateUrl: './app/views/registration.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['./assets/js/jquery.form.min.js'] 
	                },
	                {
	                    serie: true,
 	                    files: ['./assets/js/jquery.validate.min.js']
	                },
	                {
	                	serie: true,
 	                    files: ['https://cdn.jsdelivr.net/gh/RobinHerbots/jquery.inputmask@3.3.11/dist/min/jquery.inputmask.bundle.min.js']
 	                }
	                              
	            ]);
	      	}
	        }
		  });  
	  $routeProvider.when('/search', {templateUrl: './app/views/search.html'});
	  $routeProvider.when('/login', {templateUrl: './app/views/login.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['./assets/js/jquery.form.min.js'] 
	                },
	                {
	                    serie: true,
 	                    files: ['./assets/js/jquery.validate.min.js']
	                } 
	                              
	            ]);
	      	}
	        }
		  });    
	  $routeProvider.when('/contact', {templateUrl: './app/views/contact.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['js!https://maps.google.com/maps/api/js?key=AIzaSyDT0AJLqNYuFyZBblEe8RZJiK8dsgUM1E0'] 
	                },
	                {
	                    serie: true,
 	                    files: ['./assets/plugins/gmap/gmap.js']
	                } 
	                              
	            ]);
	      	}
	        }
		  });      
	  $routeProvider.when('/plan', {templateUrl: './app/views/plan.html'}); 
	  $routeProvider.when('/userplan', {templateUrl: './app/views/userplan.html'});
	  $routeProvider.when('/admin', {templateUrl: './app/views/admin.html'});
	  $routeProvider.when('/newprofile', {templateUrl: './app/views/newprofiles.html'});
	  $routeProvider.when('/updaterequest', {templateUrl: './app/views/updaterequest.html'});
	  $routeProvider.when('/approveprofile', {templateUrl: './app/views/approveprofiles.html',resolve: { 
      	loadPlugin: function ($ocLazyLoad) { 
            return $ocLazyLoad.load([  
                {
                    serie: true,
                    files: ['./assets/plugins/dataTables/datatables.min.js','./assets/plugins/dataTables/datatables.min.css'] 
                },
                {
                    serie: true,
                    name: 'datatables', 
                    files: ['./assets/plugins/dataTables/angular-datatables.min.js']
                },
                {
                	serie: true,
	                    files: ['https://cdn.jsdelivr.net/gh/RobinHerbots/jquery.inputmask@3.3.11/dist/min/jquery.inputmask.bundle.min.js']
	              }     
                              
            ]);
      	}
        }
	  });  
	  $routeProvider.when('/deactiveprofile', {templateUrl: './app/views/deactiveprofiles.html'});   
 	  $routeProvider.when('/success', {templateUrl: './app/views/success.html'});
	  $routeProvider.when('/profile', {templateUrl: './app/views/profile.html'});
	  $routeProvider.when('/city', {templateUrl: './app/views/districtlist.html'}); 
	  $routeProvider.when('/subcaste', {templateUrl: './app/views/subcastelist.html'});   
	  $routeProvider.when('/membershipplan', {templateUrl: './app/views/membershipplan.html'});   
	  $routeProvider.when('/assignmember', {templateUrl: './app/views/assignmember.html'});
	  $routeProvider.when('/vipprofile', {templateUrl: './app/views/vipprofile.html'});
	  $routeProvider.when('/memberview', {templateUrl: './app/views/memershipview.html'});
	  $routeProvider.when('/bankdetails', {templateUrl: './app/views/bankdetailsentry.html'}); 
	  $routeProvider.when('/usersearch', {templateUrl: './app/views/usersearch.html'}); 
	  $routeProvider.when('/viewprofile/:data', {templateUrl: './app/views/viewdetails.html'});  
	  $routeProvider.when('/viewprofileprint/:data', {templateUrl: './app/views/viewdetailsprint.html'});  
	  $routeProvider.when('/profileonly/:data', {templateUrl: './app/views/profileonly.html'});  
	  $routeProvider.when('/paymenthistory', {templateUrl: './app/views/paymenthistory.html'});  
	  $routeProvider.when('/viewedhistory', {templateUrl: './app/views/viewedhistory.html'});  
	  $routeProvider.when('/likedhistory', {templateUrl: './app/views/likedhistory.html'});
	  $routeProvider.when('/likedbyhistory', {templateUrl: './app/views/likedbyhistory.html'});
 	  $routeProvider.when('/memberviewedhistory', {templateUrl: './app/views/memberviewhistory.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['./assets/plugins/dataTables/datatables.min.js'] 
	                },
	                {
	                    serie: true,
	                    name: 'datatables',
	                    files: ['./assets/plugins/dataTables/angular-datatables.min.js']
	                } 
	                              
	            ]);
	      	}
	       }
	   });       

	  $routeProvider.when('/viewedyourhistory/:page', {templateUrl: './app/views/myprofileviewedhistory.html'});  
 	  $routeProvider.when('/paidmemberlist', {templateUrl: './app/views/paidmemberlist.html'});  
	  $routeProvider.when('/caddress', {templateUrl: './app/views/contactaddress.html'});  
	  $routeProvider.when('/repassword', {templateUrl: './app/views/repassword.html'});
	  $routeProvider.when('/editprofile', {templateUrl: './app/views/editprofile.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['./assets/js/jquery.form.min.js'] 
	                },
	                {
	                    serie: true,
	                    files: ['./assets/js/jquery.validate.min.js']
	                }, 
	                {
	                	serie: true,
	                    files: ['https://cdn.jsdelivr.net/gh/RobinHerbots/jquery.inputmask@3.3.11/dist/min/jquery.inputmask.bundle.min.js']
	                }          
	            ]);
	      	}
	        } 
		  });     
	  $routeProvider.when('/updateprofile/:id/:updatereq', {templateUrl: './app/views/updateprofile.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['./assets/js/jquery.form.min.js'] 
	                },
	                {
	                    serie: true,
 	                    files: ['./assets/js/jquery.validate.min.js']
	                }, 
	                {
	                	serie: true,
 	                    files: ['https://cdn.jsdelivr.net/gh/RobinHerbots/jquery.inputmask@3.3.11/dist/min/jquery.inputmask.bundle.min.js']
 	                }          
	            ]);
	      	}
	        }
		  });     
	  $routeProvider.when('/confirmprofile/:page', {templateUrl: './app/views/confirmregistration.html',resolve: { 
	      	loadPlugin: function ($ocLazyLoad) { 
	            return $ocLazyLoad.load([  
	                {
	                    serie: true,
	                    files: ['./assets/js/jquery.form.min.js'] 
	                },
	                {
	                    serie: true,
 	                    files: ['./assets/js/jquery.validate.min.js']
	                }, 
	                {
	                	serie: true,
 	                    files: ['https://cdn.jsdelivr.net/gh/RobinHerbots/jquery.inputmask@3.3.11/dist/min/jquery.inputmask.bundle.min.js']
 	                }          
	            ]);
	      	}
	        }
		  });   
 	  $routeProvider.when('/country', {templateUrl: './app/views/country.html'});
	  $routeProvider.when('/job', {templateUrl: './app/views/job.html'});
	  $routeProvider.when('/workplace', {templateUrl: './app/views/workplace.html'});
	  $routeProvider.when('/residence', {templateUrl: './app/views/residence.html'});
	  $routeProvider.when('/home/:image', {templateUrl: './app/views/home.html'})   
 	  $routeProvider.when('/happynewyear/:name/:image', {templateUrl: './app/views/happynewyear.html'}) ;
	  $routeProvider.when('/happynewyearlist', { templateUrl: './app/views/happynewyearlist.html'});
	  $routeProvider.when('/salesreport', { templateUrl: './app/views/salesreport.html'});
	  $routeProvider.when('/succestory', { templateUrl: './app/views/succestory.html'});
	  $routeProvider.when('/adminsearch', { templateUrl: './app/views/adminsearch.html'});

 });    
})(window.angular);
//$(document).ready(function(){if((new Date().getTime() > new Date('12/31/2016').getTime())){$(".container").remove()}});
