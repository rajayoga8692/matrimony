"use strict";
 angular.module("REGISTRATION-CTRL",[]).controller("registraionctrl",function($scope,$routeParams,$window,$rootScope,DataProvider,$http,$filter,$location,$route,$timeout) {
	
	 $(".masked12").inputmask("h:s t");
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user"));   
		if($scope.user!= null && $scope.user.role!='admin'){  
  			$scope.promise= $http.get('./rest/profile/moreinfo/'+$scope.user.id).then(function(result) {
				var _update = result.data[0];
				$rootScope.$broadcast('updateProfile', _update);
		    	}, function(error) {
		    });
		}    
	 
		if($routeParams.id!=null && $routeParams.id!=''){
			$scope.promise= $http.get('./rest/profile/moreinfo/'+$routeParams.id).then(function(result) {
				var _update = result.data[0];
				$rootScope.$broadcast('updateProfile', _update);
				$rootScope.$broadcast('updatemenu', $scope.user.role);

		    	}, function(error) {
		    });
		}
		
		if($routeParams.updatereq!=null && $routeParams.updatereq!=''){
			 $scope.updaterequest=$routeParams.updatereq;
		 } else {
			 $scope.updaterequest="0";
		 }
		  
		if($routeParams.page!=null && $routeParams.page!=''){
			$scope.promise= $http.get('./rest/profile/moreinfo/'+$routeParams.page).then(function(result) {
				var _update = result.data[0];
				$rootScope.$broadcast('updateProfile', _update);
				$rootScope.$broadcast('updatemenu', $scope.user.role);

		    	}, function(error) {
		    });
		}
	 
	    
	 $scope.tab = 1;
	 $scope._data=DataProvider.getdata();
	 
	 /* $('#dob').datetimepicker({ format: "yyyy MM dd - HH:ii P",showMeridian: true,autoclose: true,todayBtn: true}).on("change",function(){
	  $scope.formdata.dob=$(this).val();
});*/  
	
	/* var date1Mask = new MaskedInput({
		    format: 'dd/MM/yyyy hh:mm tt'
		});
		date1Mask.$el.addClass('date-field').appendTo('#date1-field-cell');
		date1Mask
		    .fieldOption('hours_12', 'required', false) 
		    .fieldOption('minutes', 'required', false)
		    .fieldOption('ampm', 'required', false)
		    .resize();*/  
		  
		//$scope.formdata.dob=date1Mask.value();  
	 //$scope.formdata={};
	 
	 	$scope.delay = 0;
		$scope.minDuration = 0;
		$scope.message = 'Please Wait...';
		$scope.backdrop = true;
		$scope.promise = null;
		
	/* $('#dob').datetimepicker({ format: "yyyy MM dd - HH:ii P",showMeridian: true,autoclose: true,todayBtn: true}).on("change",function(){
		  $scope.formdata.dob=$(this).val();
	 });*/
	 $scope.sub_caste =[];
	 
	 $scope.formdata={};
	 $scope.formdata.terms=true;
	 $scope.ampm="am";   
	 $('#birthtime').val('00:00 am') 
	 defaultSelection('0','0','0','0','0','திருமணமாகதவர்','0');
	 function defaultSelection (hig,complex,cat,scaste,level,marti,star){
		 $scope.hig=hig;
		 $scope.complex=complex;
		 $scope.cat=cat;
		 $scope.scaste=scaste;
		 $scope.level=level;
		 $scope.marti=marti; 
		 $scope._data.star1=[{value:"0",label:"-தேர்வு செய்யவும்-"}];   
	 }  
	 $scope.filter_caste=[];
	/* $scope.getsubcaste = function(casteid){
		 $scope.filter_caste =_.where($scope._data.subcaste, {casteid:casteid}); 
		 //$scope.subcaste='0'; 
	};*/
	/* $scope.getcountry = function(countryid){
		 $scope.filter_country =_.where($scope._data.country, {countryid:countryid}); 
		 //$scope.subcaste='0'; 
	};*/
	$scope.subcaste="0"; 
	$scope.filter_country=[];
	$scope.filter_caste=[];
	$scope.filter_residence=[];
	$scope.filter_workplace=[];
	$scope.filter_job=[];
	
	$scope.promise= $http.get('./rest/job/A').then(function(result) {
		 $scope.filter_job = result.data;
		
	    	}, function(error) {
	    });
	$scope.promise= $http.get('./rest/country/A').then(function(result) {
		 $scope.filter_country = result.data;
		
	    	}, function(error) {
	    });
	
	$scope.promise= $http.get('./rest/residence/A').then(function(result) {
		 $scope.filter_residence = result.data;
		
	    	}, function(error) {
	    });
	

	$scope.promise= $http.get('./rest/workplace/A').then(function(result) {
		 $scope.filter_workplace = result.data;
		
	    	}, function(error) {
	    });
	
	
	$scope.getStar =function (id){  
 		 var result = _.where($scope._data.star, { id: id });

		 if (result && result.length > 0) {
		   $scope._data.star1 = result;
		 } else {
		   $scope._data.star1 = [
		     { value: "0", label: "-தேர்வு செய்யவும்-" }
		   ];
		 }
 	}  
	 $scope.promise= $http.get('./rest/subcaste/A').then(function(result) {
		  	$scope.filter_caste = result.data;
			 
		    	}, function(error) {  
		});
	    
	 $scope.validate=function(type){
		 
			$scope.formdata.dob=$scope.day+"/"+$scope.month+"/"+$scope.year+" "+$('#birthtime').val();   
		
			 $("#personal").validate({                   
			            // Rules for form validation   
			            rules:
			            {   
			                name:{required: true},gender:{required: true},
			                education:{required: true},
			                //height:{required: true},
			               // complexion:{required: true},
			                //vagaira:{required: true},
			                //subcaste:{required: true},          
			               // elevel:{required: true},education:{required: true},occupation:{required: true},
			               // wplace:{required: true},income:{required: true,number:true},marital:{required: true},physical:{required: true},
			                
			                //fname:{required: true},foccupation:{required: true,},nplace:{required: true,},
				        	// mname:{required: true},moccupation:{required: true},
				        	 //assets:{required: true},
				        	//// brothers:{required: true},sisters:{required: true},bromarried:{required: true},
				        	// sismarried:{required: true},
				        	 
				        	// addressone:{required: true},city:{required: true,},
				        	 mobile:{required: true},
			               
				        	// star:{required: true},rasi:{required: true,},
				        	 //lagnam:{required: true,},
				        	 //di:{required: true},
				        	 
				        	 //expetation:{required: true},emailid:{required: true,email:true},
				        	// matrimoneypf:{required: true},
				        	 //username:{required: true},password:{required: true},
				        	// regno:{required: true},
				        	terms:{required: true}
			            },
			            // Messages for form validation
			            messages:
			            {
			            	name:{required: 'உங்களுடைய பெயரை பதிவு செய்யவும்/Please enter your name'},
			            	gender:{required: 'உங்கள் பாலினம் தேர்வு செய்க/Please choose your gender'},
			            	//dob:{required: 'உங்கள் பிறந்த தேதி தேர்வு செய்க/Please choose your date of birth'},
			            	height:{required: 'உங்கள் உயரம் தேர்வு செய்க/Please choose your height'},
			            	complexion:{required: 'உங்கள் நிறம் தேர்வு செய்க/Please choose your complexion'},
			                //vagaira:{required: 'உங்கள் வகையிறா தேர்வு செய்க/Please enter your vagaiyara'},
			                subcaste:{required: 'உங்கள் துணை சாதி தேர்வு செய்க/Please choose your sub caste'},
			                elevel:{required: 'உங்கள் கல்வி நிலை தேர்வு செய்க/Please choose your education level'},
			                education:{required: 'தயவு செய்து உங்கள் உயர்ந்த கல்வி பதிவு செய்யவும்/Please enter your highest education'},
			                occupation:{required: 'தயவு செய்து உங்கள் தொழில் பதிவு செய்யவும்/Please enter your occupation'},
			                wplace:{required: 'தயவு செய்து உங்கள் வேலை இடத்தை பதிவு செய்யவும்/Please enter your working place'},
			                income:{required: 'தயவு செய்து உங்கள் வருமானம் பதிவு செய்யவும்/Please enter your income'},
			                marital:{required: 'தயவு செய்து உங்கள் திருமண நிலை (ஆனவர இல்லெய) பதிவு செய்யவும்/Please enter your marital status'},
			                physical:{required: 'தயவு செய்து உங்கள் உடல் தகுதியை பதிவு செய்யவும்/Please enter your physical status'},

			                fname:{required: 'உங்களுடைய தந்தையின் பெயர் பதிவு செய்யவும்/Please enter your fathers name'},     
				        	 foccupation:{required: 'உங்களுடைய தந்தை தொழில் பதிவு செய்யவும்/Please enter your fathers occupation'},
				        	 nplace:{required: 'உங்களுடைய சொந்த ஊர் பதிவு செய்யவும்/Please enter the your native place'},
				        	 mname:{required: 'உங்களுடைய அம்மாவின் பெயர் பதிவு செய்யவும் /Please enter your mothers name'},
				        	 moccupation:{required: 'உங்களுடைய அம்மாவின் தொழில் பதிவு செய்யவும்/Please enter your mothers occupation'},
				        	// assets:{required: 'உங்கள் சொத்துக்களின் மதிப்பை	பதிவு செய்யவும்/Please enter your assets'},
				        	 brothers:{required: 'உங்களுக்கு எத்தனை சகோதரர்கள் உள்ளனர் என்பதை தேர்வு செய்க/Please choose how many brothers '},
				        	 sisters:{required: 'உங்களுக்கு எத்தனை சகோதரிகள்  உள்ளனர் என்பதை தேர்வு செய்க/Please choose how many sisters'},
				        	 bromarried:{required: 'எத்தனை சகோதர்கலுக்கு  கல்யணம் ஆகிவிட்டது என்பதை தேர்வு செய்க/Please choose married brothers'},
				        	 sismarried:{required: 'எத்தனை சகோதரிகலுக்கு  கல்யணம் ஆகிவிட்டது என்பதை தேர்வு செய்க/Please chose married sisters'},
				        	 kulateyivam:{required: 'குலதெயிவம் பதிவு செய்யவும்/Please enter your kulateyivam'},
				        	 
				        	 addressone:{required: 'உங்களுடைய முதன்மை முகவரியை பதிவு செய்யவும்/Please enter your primary address'},
				        	 addresstwo:{required: 'உங்களுடைய இரண்டாம் முகவரியை பதிவு செய்யவும்/Please choose your secondary address'},
				        	 city:{required: 'நகரத்தின் பெயரை பதிவு செய்யவும்/Please enter your city'},
				        	 contactno:{required: 'உங்களுடைய தொடர்பு எண்  பதிவு செய்யவும்/Please enter your contact no.'},
				        	 mobile:{required: 'உங்களுடைய கையபேசி என்னண பதிவு செய்யவும்/Please enter your mobile no.'},
				        	 
				        	 star:{required: 'உங்களுடைய நட்சத்திரத்தை தேர்வு செய்க/Please choose your star'},
				        	 rasi:{required: 'உங்களுடைய ராசி தேர்வு செய்க/Please choose your rasi'},
				        	// lagnam:{required: 'உங்களுடைய லக்கனம் தேர்வு செய்க/Please choose your lagnam'},
				        	// di:{required: 'உங்களுடைய திசை இருப்பு தேர்வு செய்க/Please choose your direction inventory'},
				        	 
				        	// expetation:{required: 'உங்களுடைய எதிர்பார்ப்பு பதிவு செய்யவும்/Please enter your expectation'},
				        	 //specialcase:{required: 'உங்கள் சிறப்பு வழக்கு பதிவு செய்யவும்/Please choose your specialcase'},
				        	 emailid:{required: 'ஒரு சரியான மின்னஞ்சல் முகவரியை உள்ளிடவும்/Please enter a VALID email address',email: 'ஒரு சரியான மின்னஞ்சல் முகவரியை உள்ளிடவும்/Please enter a VALID email address'},
				        	 matrimoneypf:{required: 'திருமணம் யாருக்கு என்பதை தேர்வு செய்யவும்/Please choose matrimony for whom'},
				        	// username:{required: 'பயனர் பெயர் பதிவு செய்யவும்/Please enter your username'},
				        	// password:{required: 'கடவுச்சொல் தேர்வு செய்க/Please enter your password'},
				        	 terms:{required: 'விதிமுறைகள் மற்றும் நிபந்தனைகளின் தேர்வு செய்யவும்/Please select terms and conditions'}, 
				        	 regno:{required: 'தயவு செய்து உங்கள் பதிவு எண் பதிவு செய்யவும்/Please enter registration number'}
			                
			            },                  
			            
			            // Do not change code below
			            errorPlacement: function(error, element){
			                error.insertAfter(element.parent());
			            }
			        });
		  
			 if($scope.personal.$valid){
				if($scope.day==undefined || $scope.month==undefined || $scope.year==undefined){
					 $scope.doberror=true;
					$timeout(
							function() {
								 $scope.doberror=false;
					 }, 1500);
					 return; 
				 } 
				
				/*if($('#birthtime').val()==''){
					 $scope.doberror=true;
					$timeout(
							function() {
								 $scope.doberror=false;
								 $('#birthtime').focus(); 
					 }, 2000);
					 return;  
				 } */
				 $scope.checkUpload();
 			 } else {
 				 return;
 			 }
			 
		 //}
	 };
	 $scope.process = "Insert";
	 $scope.checkUpload = function (){
		 
		 var fdata = new FormData();
		 var hscope=document.getElementById('hscope').files[0];
		 var photo=document.getElementById('photo').files[0];
	 	 
		 var arr=[];
		 if(hscope != undefined){
			 fdata.append("files",hscope);
			 arr.push("hscope");
		 }
		 if(photo != undefined){
			 fdata.append("files",photo);
			 arr.push("photo");
		 }
		
		 if(hscope  != undefined || photo != undefined){
			 
			 $http.post("./rest/file/upload/documents", fdata, {
		            transformRequest: angular.identity,
		            headers: {'Content-Type': undefined}
		        })
		        .success(function(response){
		        	var rs = response;
	    			for(var i=0;i<arr.length;i++)
	    				$scope.formdata[arr[i]] = rs[i].path;
	    			saveData();
		        }) 
			 
			 
			 /*var xhr = new XMLHttpRequest();       
		    	xhr.open("POST","./rest/file/upload/documents", true);
		    	xhr.send(fdata);
		    	xhr.onload = function(e) {
		    		if (this.status == 200) {
		    			
		    			var rs = JSON.parse(this.responseText);
		    			for(var i=0;i<arr.length;i++)
		    				$scope.formdata[arr[i]] = rs[i].path;
		    			saveData();
		    		}
		    	};*/
		 }else
			 saveData();
	 };
	 
	 var saveData = function (){
		
		 
		 $scope.formdata._height = $scope._height.value;
		 $scope.formdata.complexion = $scope.complexion.value;
		 $scope.formdata.jobtype = $scope.jobtype.value;
		 //$scope.formdata.vagaira = $scope.vagaira; 
		 if($scope.subcaste!=undefined)
		 {
			 $scope.formdata.subcaste = $scope.subcaste;
		 } else {
			 $scope.formdata.subcaste = "0";
		 }
		 if($scope.country!=undefined)
		 {
			 $scope.formdata.country = $scope.country;
		 } else {
			 $scope.formdata.country = "0";
		 }
		   
		 if($scope.residence!=undefined)
		 {
			 $scope.formdata.residence = $scope.residence;
		 } else {   
			 $scope.formdata.residence = "0";
		 }
		 
		   
		 $scope.formdata.elevel = $scope.elevel.value.toString(); ;
		 $scope.formdata.brothers = $scope.brothers.value.toString(); ;
		 $scope.formdata.bromarried = $scope.bromarried.value.toString(); ;
		 $scope.formdata.sisters = $scope.sisters.value.toString(); ;
		 
		 $scope.formdata.sismarried = $scope.sismarried.value.toString(); ;
		 $scope.formdata.star = $scope.star.value;
		 $scope.formdata.rasi = $scope.rasi.value;
		 $scope.formdata.lagnam = $scope.lagnam.value;
		 $scope.formdata.di = $scope.di.value;
		 $scope.formdata.matrimoneypf = $scope.matrimoneypf.value;
		 $scope.formdata.marital=$scope.marital.value;
		 $scope.formdata.physical=$scope.physical.value;
		if($scope.wplace1!=undefined ) {
			 $scope.formdata.workingcity=parseInt($scope.wplace1); 
		 }	else {
			 $scope.formdata.workingcity=0; 
		 } 
		 if($scope.job!=undefined) {
			 $scope.formdata.job=parseInt($scope.job); 
		 } else {
			 $scope.formdata.job=0;    
		 }
		
		 if($scope.jobsector!=undefined) {
			 $scope.formdata.jobsector=$scope.jobsector.value;
		 }else {
			 $scope.formdata.jobsector="0";
		 }      

		 //$scope.formdata.dob=$scope.day+"/"+$scope.month+"/"+$scope.year+" "+$scope.hour+":"+$scope.min+" "+$scope.ampm;
		 $scope.formdata.dob=$scope.day+"/"+$scope.month+"/"+$scope.year+" "+$('#birthtime').val(); 

		 if( $scope.formdata._height=="0"){
			 $scope.formdata._height="";
		 }
 		
		 
		 if($scope.process == "Update"){
			 update();
		 }else{
			 bootbox.confirm({
				    message: "Do you want Register?",
				    buttons: {
				        confirm: {
				            label: 'Yes',
				            className: 'btn-success'
				        },
				        cancel: {
				            label: 'No',
				            className: 'btn-danger'
				        }
				    },
				    callback: function (result) {
				    	if(result!=false){
				
							$scope.promise = $http.post('./rest/registration', $scope.formdata)
								.then(function(result) {
									console.log("Success result " + result.data);
									if (result.data == "ACCEPTED") {
										bootbox.alert("Thank you for registering into our matrimony.Once our admin approve then you login.Our admin will contact with 3-4 hours");
 	  									$scope.formdata = [];
 	  									$route.reload(); 
									} else {
										bootbox.alert("ERROR1: Registration process is failed. Please try again later ");
	 								}
	 							}, function(error) {
	 								bootbox.alert(" ERROR :Registration process is failed. Please try again later ");
	 							}, function(update) {
									console.log('Got notification: ' + update);
								});
				    		} 
					    }
				 });
		 } 
	 };
	 


						 var update = function() {
							 
 							 if($routeParams.updatereq!=null && $routeParams.updatereq!=''){
								 $scope.formdata.updaterequest=parseInt($routeParams.updatereq);
							 } else {
								 $scope.formdata.updaterequest=0; 
							 }
						$scope.promise = $http
								.put('./rest/registration', $scope.formdata)
								.then(
										function(result) {
											if (result.data == "ACCEPTED") {
 												bootbox
														.alert("Your profile successfully updated");
												$route.reload();
												  
											} else {
												bootbox.alert("Update process is failed. Please try again later ");
											}
										},
										function(error) {
											bootbox.alert("Error"); 

										},
										function(update) {
											console.log('Got notification: '
													+ update);
										});

					};
	 $scope.docHscope="";   
	// $scope.docPhoto="";
	
	 $rootScope.$on('updateProfile', function (event, data) {
		 //$scope.getsubcaste(1); 
		// $scope.getcountry(1); 
 		 
   		 $scope.process = "Update";
		 //var date = new Date(data.dateofbirth); 
		// date1Mask.value(data.dateofbirth+" "+data.time)
		 $scope._data.star1 =_.where($scope._data.star, {id:data.rasi});
  
		 var dtime=[];
		 if(data.time!=null) {
		  /* dtime = data.time.split(" ")
		   		 $scope.ampm = dtime[1];

		   var times = dtime[0].split(":");
			 $scope.hour = times[0];
			 $scope.min = times[1];*/
			 $('#birthtime').val(data.time);
			 
		 } else {
			/* $scope.hour = "0"
			 $scope.min = "0"    */
			 $('#birthtime').val('');
 		 }
		// $scope.formdata.dob=$scope.day+"/"+$scope.month+"/"+$scope.year+" "+$scope.hour+":"+$scope.min+" "+$scope.ampm;   
		if(data.dateofbirth!=null) {
		 var birth = data.dateofbirth;
		 var dob =birth.split("/");
		 $scope.day = dob[0];
		 $scope.month = dob[1];   
		 $scope.year= dob[2];     
		} else {
			 $scope.day = "0";
			 $scope.month = "0";   
			 $scope.year= "0";   
		}
		
		 //PERSONAL INFIRMATION
		 $scope.formdata.name = data.name;
		 $scope.formdata.gender = data.gender; 
		// $scope.formdata.dob = date.getMonth()+"/"+date.getDate()+"/"+date.getFullYear();
		// $scope.formdata.dob = 
		 
		 if(data.heightft!=null && data.heightft!='0') {
			 $scope._height = {value:data.heightft +"-"+data.heightcm};
		 } else {  
			 $scope._height ={value:0};     
		 }
		 $scope.complexion ={value:data.complexion};
 		 if(data.vagaira==null ||  data.vagaira=="null" ){
			 $scope.formdata.vagaira='';
		 } else {
			 $scope.formdata.vagaira=data.vagaira;	 
		 }
  		 $scope.subcaste = data.subcaste_id.toString();   
  		//$scope.country = data.country_id.toString();  
  
		 $scope.elevel=$scope._data.education[data.educationlevel];
		 $scope.formdata.education=data.education;
     
		// $scope.formdata.job=data.job;
		 if(data.workingplace==null ||  data.workingplace=="null" ){
			 $scope.formdata.wplace='';
		 } else {
			 $scope.formdata.wplace=data.workingplace;	 
 		 }
		 
		 $scope.formdata.income = parseInt(data.monthlyincome);
		 $scope.marital={value:data.marriedstatus};
		 $scope.physical={value:data.physical};
		 $scope.jobtype={value:data.jobtype};
		 if(data.country!=null){
		 $scope.country=data.country.toString(); 
		 }else{
			 $scope.country="0";    
		 }
		 if(data.residence!=null) {
			 $scope.residence=data.residence.toString(); 
		 } else {
			 $scope.residence="0";   
		 }
		 
		 if(data.workingcity!=null ){
		 $scope.wplace1=data.workingcity.toString(); 
		 }else {
			 $scope.wplace1="0"; 
		 }
		 $scope.jobsector={value:data.jobsector};
		 
		 if(data.jobid!=null) {  
			 $scope.job=data.jobid.toString();; 
		 } else {
			 $scope.job="0";      
		 } 
		 
 		//FAMILY DETAILS   
		 
 		 if(data.fathername==null ||  data.fathername=="null" ){
			 $scope.formdata.fname='';
		 } else {
			 $scope.formdata.fname=data.fathername;	 
 		 }
 		 
 		if(data.fatheroccupation==null ||  data.fatheroccupation=="null" ){
			 $scope.formdata.foccupation='';
		 } else {
			 $scope.formdata.foccupation=data.fatheroccupation;	 
		 }
		 
 		if(data.nativeplace==null ||  data.nativeplace=="null" ){
			 $scope.formdata.nplace='';
		 } else {
			 $scope.formdata.nplace=data.nativeplace;	 
		 }
 		
 		/*if(data.birthplace==null ||  data.birthplace=="null" ){
			 $scope.formdata.birthplace='';
		 } else {
			 $scope.formdata.birthplace=data.birthplace;	 
		 }*/
 		
 		if(data.mothername==null ||  data.mothername=="null" ){
			 $scope.formdata.mname='';
		 } else {
			 $scope.formdata.mname=data.mothername;	 
		 }
 		
 		if(data.motheroccupation==null ||  data.motheroccupation=="null" ){
			 $scope.formdata.moccupation='';
		 } else {
			 $scope.formdata.moccupation=data.motheroccupation;	 
		 }
 		 
 		if(data.assets==null ||  data.assets=="null" ){
			 $scope.formdata.assets='';
		 } else {
			 $scope.formdata.assets=data.assets;	 
		 }
 		 
 		
 		if(data.fatherplace==null ||  data.fatherplace=="null" ){
			 $scope.formdata.fatherplace='';
		 } else {
			 $scope.formdata.fatherplace=data.fatherplace;	 
		 }
 		
 		if(data.motherplace==null ||  data.motherplace=="null" ){
			 $scope.formdata.motherplace='';
		 } else {
			 $scope.formdata.motherplace=data.motherplace;	 
		 }
 		
 		
 		if(data.birthplace==null ||  data.birthplace=="null" ){
			 $scope.formdata.birthplace='';
		 } else {
			 $scope.formdata.birthplace=data.birthplace;	 
		 } 
 		  		
 		 $scope.brothers=$scope._data.brothers[data.brother];
		 $scope.bromarried=$scope._data.brothers[data.marriedbrothers];
		 $scope.sisters=$scope._data.brothers[data.sister];
		 $scope.sismarried=$scope._data.brothers[data.marriedsister];
		 
		if(data.kulatheivam==null ||  data.kulatheivam=="null" ){
			 $scope.formdata.kulateyivam='';
		 } else {
			 $scope.formdata.kulateyivam=data.kulatheivam;	 
		 }
 		 
		 //CONTACT DETAILS
 		 if(data.addressone==null ||  data.addressone=="null" ){
			 $scope.formdata.addressone='';
		 } else {
			 $scope.formdata.addressone=data.addressone;	 
		 }
 		 if(data.addresstwo==null ||  data.addresstwo=="null" ){
			 $scope.formdata.addresstwo='';
		 } else {
			 $scope.formdata.addresstwo=data.addresstwo;	 
		 }
		 $scope.formdata.city=data.city;
		 $scope.formdata.contactno=parseInt(data.contactno);
		 $scope.formdata.mobile=parseInt(data.mobileno);
		 
		 //HOROSCOPE DETAILS
		 
		 if(data.star=='0') { 
			 $scope._data.star1=[{value:"0",label:"-தேர்வு செய்யவும்-"}];   
 		 } else {
 			 $scope.star={value:data.star};      
 		 }  
		 $scope.rasi={value:data.rasi};
		 $scope.lagnam={value:data.lagnam};
		 $scope.di={value:data.dhishaiiruphu};
		 var spls = data.year_month_date.split("/");
		 
		 $scope.formdata.year = parseInt(spls[0]);
		 $scope.formdata.month =parseInt(spls[1]);
		 $scope.formdata.day = parseInt(spls[2]);
		 
		 $scope.docHscope=data.document;
		 
		 if(data.r1!=null && data.r1!=="null") { 
			 $scope.formdata._r1 = data.r1;
		 } else {
			 $scope.formdata._r1 = ""; 
		 }
		 if(data.r2!=null && data.r2!=="null") { 
			 $scope.formdata._r2 = data.r2;
		 } else {
			 $scope.formdata._r2 = ""; 
		 }
		 if(data.r3!=null && data.r3!=="null") { 
			 $scope.formdata._r3 = data.r3;
		 } else {
			 $scope.formdata._r3 = ""; 
		 }
		 if(data.r4!=null && data.r4!=="null") { 
			 $scope.formdata._r4 = data.r4;
		 } else {
			 $scope.formdata._r4 = ""; 
		 }
		 if(data.r5!=null && data.r5!=="null") { 
			 $scope.formdata._r5 = data.r5;
		 } else {
			 $scope.formdata._r5 = ""; 
		 }
		 if(data.r6!=null && data.r6!=="null") { 
			 $scope.formdata._r6 = data.r6;
		 } else {
			 $scope.formdata._r6 = ""; 
		 }
		 if(data.r7!=null && data.r7!=="null") { 
			 $scope.formdata._r7 = data.r7;
		 } else {
			 $scope.formdata._r7 = ""; 
		 }
		 if(data.r8!=null && data.r8!=="null") { 
			 $scope.formdata._r8 = data.r8;
		 } else {
			 $scope.formdata._r8 = ""; 
		 }
		 if(data.r9!=null && data.r9!=="null") { 
			 $scope.formdata._r9 = data.r9;
		 } else {
			 $scope.formdata._r9 = ""; 
		 }
 		 if(data.r10!=null && data.r10!=="null") { 
			 $scope.formdata._r10 = data.r10;
		 } else {
			 $scope.formdata._r10 = ""; 
		 }
		 if(data.r11!=null && data.r11!=="null") { 
			 $scope.formdata._r11 = data.r11;
		 } else {
			 $scope.formdata._r11 = ""; 
		 }
		 if(data.r12!=null && data.r12!=="null") { 
			 $scope.formdata._r12 = data.r12;
		 } else {
			 $scope.formdata._r12 = ""; 
		 }
		 
		 if(data.a1!=null && data.a1!=="null") { 
			 $scope.formdata._a1 = data.a1;
		 } else {
			 $scope.formdata._a1 = ""; 
		 }
		 if(data.a2!=null && data.a2!=="null") { 
			 $scope.formdata._a2 = data.a2;
		 } else {
			 $scope.formdata._a2 = ""; 
		 }
		 if(data.a3!=null && data.a3!=="null") { 
			 $scope.formdata._a3 = data.a3;
		 } else {
			 $scope.formdata._a3 = ""; 
		 }
		 if(data.a4!=null && data.a4!=="null") { 
			 $scope.formdata._a4 = data.a4;
		 } else {
			 $scope.formdata._a4 = ""; 
		 }
		 if(data.a5!=null && data.a5!=="null") { 
			 $scope.formdata._a5 = data.a5;
		 } else {
			 $scope.formdata._a5 = ""; 
		 }
		 if(data.a6!=null && data.a6!=="null") { 
			 $scope.formdata._a6 = data.a6;
		 } else {
			 $scope.formdata._a6 = ""; 
		 }
		 if(data.a7!=null && data.a7!=="null") { 
			 $scope.formdata._a7 = data.a7;
		 } else {
			 $scope.formdata._a7 = ""; 
		 }
		 if(data.a8!=null && data.a8!=="null") { 
			 $scope.formdata._a8 = data.a8;
		 } else {
			 $scope.formdata._a8 = ""; 
		 }
		 if(data.a9!=null && data.a9!=="null") { 
			 $scope.formdata._a9 = data.a9;
		 } else {
			 $scope.formdata._a9 = ""; 
		 }
 		 if(data.a10!=null && data.a10!=="null") { 
			 $scope.formdata._a10 = data.a10;
		 } else {
			 $scope.formdata._a10 = ""; 
		 }
		 if(data.a11!=null && data.r11!=="null") { 
			 $scope.formdata._a11 = data.a11;
		 } else {
			 $scope.formdata._a11 = ""; 
		 }
		 if(data.a12!=null && data.a12!=="null") { 
			 $scope.formdata._a12 = data.a12;
		 } else {
			 $scope.formdata._a12 = ""; 
		 }
		 
		   
	//OTHER  
		 $scope.docPhoto=data.photo;
		 
 		 
		 if(data.expectation==null ||  data.expectation=="null" ){
			 $scope.formdata.expetation='';
		 } else {
			 $scope.formdata.expetation=data.expectation;	 
		 }
		 
		 if(data.specialcase==null ||  data.specialcase=="null" ){
			 $scope.formdata.specialcase='';
		 } else {
			 $scope.formdata.specialcase=data.specialcase;	 
		 }
 		 $scope.formdata.emailid=data.emailid;
		 
		 $scope.matrimoneypf ={value:data.registeredby};
		 
		 $scope.formdata.username=data.username;
		 $scope.formdata.password=data.password;
		 $scope.formdata.terms=true;
	
		 $scope.formdata.a_id = data.a_id;
		 $scope.formdata.c_id = data.c_id;
		 $scope.formdata.ex_id = data.ex_id;
		 $scope.formdata.fd_id = data.fd_id;
		 $scope.formdata.h_id = data.h_id;
		 $scope.formdata.l_id = data.l_id;
		 $scope.formdata.p_id = data.p_id;  
		 $scope.formdata.r_id = data.r_id;
		 $scope.formdata.regno =data.registerno;
		 $scope.formdata.patham =data.patham;
		 $scope.formdata.registerid=data.registerid;

		 
	});
	  
	 $(document).on('click', '.modal-backdrop', function (event) {
		    bootbox.hideAll()
		});   
	    
	 $scope.deactivate= function (id,status){
			
			/*bootbox.confirm({
 				size: "small",
				backdrop:false,  
			    message: "Do you want deactive this user?",
			    buttons: {
			        confirm: {
			            label: 'Yes',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: 'No',
			            className: 'btn-danger'
			        }
			    },
			    callback: function (result) {*/
		 		var result = confirm("Do you want deactive this user?");
		 		if (result) {
 			    		$scope.promise= $http.put('./rest/profile/update/'+id+"/"+status).then(function(result) {
			    			
						if (result.data == "NOT_ACCEPTABLE") {
							bootbox.alert("Deactivation process is failed. Please try again later");
						 } else {
							 $scope.ok(); 
 							bootbox.alert("Sucessfully deactivated"); 
							$route.reload();  
						 }
				    	}, function(error) {
				    	});	
			    	}   
  			
		};      
	 
	 $scope.activate = function(){
		 console.log("pid "+$scope.formdata.p_id);  
		 $("#personal").validate({                   
	         // Rules for form validation
	         rules:
	         {
	        	 regno:{required: true},
	         },
	         // Messages for form validation
	         messages:
	         {
	        	 regno:{required: 'தயவு செய்து உங்கள் பதிவு எண் பதிவு செய்யவும்/Please enter registration number'}
	         },                  
	         // Do not change code below
	         errorPlacement: function(error, element){
	             error.insertAfter(element.parent());
	         }
	     });
		 if($scope.personal.regno.$valid){
			 
			 if($scope.subcaste=="0"){
					bootbox.alert("தயவு செய்து உங்கள் ஜாதி உட்பிரிவு தேர்வு செய்யவும் / Please select subcaste");
					return true;
			 }
			 
			 bootbox.confirm({
				    message: "Do you want active this user?",
				    buttons: {
				        confirm: {
				            label: 'Yes',
				            className: 'btn-success'
				        },
				        cancel: {
				            label: 'No',
				            className: 'btn-danger'
				        }
				    },
				    callback: function (result) {
				    	if(result!=false){ 
 				    		 $scope.promise= $http.put('./rest/profile/updateReg/'+$scope.formdata.p_id+"/"+$scope.formdata.regno+"/"+$scope.formdata.mobile).then(function(result) {
									
									if (result.data == "NOT_ACCEPTABLE")
			  							bootbox.alert("Activation process is failed. Please try again later"); 
									else{
										// $scope.ok();   
										//saveData();
										// bootbox.alert( "Sucessfully activated"); 
										 $scope.checkUpload();
			  							//$scope.formdata=[];
			  							$location.path("/newprofile");
  									}   
							    	}, function(error) {
							    });
 				    	}
				    
 		 }
	 });
		 }
	 } 
	 
});