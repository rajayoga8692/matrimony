"use strict";
angular.module('data-provider',[]).provider("DataProvider",function(){
	var data={	
             	height:[
             	        {value:0,label:'-தேர்வு செய்யவும்-'},{ value:"3ft.5in-105cm",label:"3ft.5in-105cm"},
             	        { value:"3ft.6in-107cm",label:"3ft.6in-107cm"},{ value:"3ft.7in-110cm",label:"3ft.7in-110cm"},
             	        { value:"3ft.8in-112cm",label:"3ft.8in-112cm"},{ value:"3ft.9in-115cm",label:"3ft.9in-115cm"},
             	        { value:"3ft.10in-117cm",label:"3ft.10in-117cm"},{ value:"3ft.11in-120cm",label:"3ft.11in-120cm"},
             	        { value:"4ft-122cm",label:"4ft-122cm"},{ value:"4ft.1in-125cm",label:"4ft.1in-125cm"},
             	        { value:"4ft.2in-127cm",label:"4ft.2in-127cm"},{ value:"4ft.3in-130cm",label:"4ft.3in-130cm"},
             	        { value:"4ft.4in-132cm",label:"4ft.4in-132cm"},{ value:"4ft.5in-135cm",label:"4ft.5in-135cm"},
             	        { value:"4ft.6in-137cm",label:"4ft.6in-137cm"},{ value:"4ft.7in-140cm",label:"4ft.7in-140cm"},
             	        { value:"4ft.8in-142cm",label:"4ft.8in-142cm"},{ value:"4ft.9in-145cm",label:"4ft.9in-145cm"},
             	        { value:"4ft.10in-147cm",label:"4ft.10in-147cm"},{ value:"4ft.11in-150cm",label:"4ft.11in-150cm"},
             	        { value:"5ft-152cm",label:"5ft-152cm"},{ value:"5ft.1in-155cm",label:"5ft.1in-155cm"},
             	        { value:"5ft.2in-157cm",label:"5ft.2in-157cm"},{ value:"5ft.3in-160cm",label:"5ft.3in-160cm"},
             	        { value:"5ft.4in-162cm",label:"5ft.4in-162cm"},{ value:"5ft.5in-165cm",label:"5ft.5in-165cm"},
             	        { value:"5ft.6in-167cm",label:"5ft.6in-167cm"},{ value:"5ft.7in-170cm",label:"5ft.7in-170cm"},
             	        { value:"5ft.8in-172cm",label:"5ft.8in-172cm"},{ value:"5ft.9in-175cm",label:"5ft.9in-175cm"},
             	        { value:"5ft.10in-177cm",label:"5ft.10in-177cm"},{ value:"5ft.11in-180cm",label:"5ft.11in-180cm"},
             	        { value:"6ft-182cm",label:"6ft-182cm"},{ value:"6ft.1in-185cm",label:"6ft.1in-185cm"},
             	        { value:"6ft.2in-187cm",label:"6ft.2in-187cm"},{ value:"6ft.4in-192cm",label:"6ft.4in-192cm"},
             	        { value:"6ft.5in-195cm",label:"6ft.5in-195cm"},{ value:"6ft.6in-197cm",label:"6ft.6in-197cm"},
             	        { value:"6ft.7in-200cm",label:"6ft.7in-200cm"},{ value:"6ft.8in-202cm",label:"6ft.8in-202cm"},
             	        { value:"6ft.9in-205cm",label:"6ft.9in-205cm"},{ value:"6ft.10in-207cm",label:"6ft.10in-207cm"},
             	        { value:"6ft.11in-210cm",label:"6ft.11in-210cm"}
    				 ],
    			complexion:[
    			            {value:0,label:'-தேர்வு செய்யவும்-'},{value:'சிவப்பு',label:'சிவப்பு'},{value:'புதுநிறம்',label:'புதுநிறம்'},{value:'கருப்பு',label:'கருப்பு'},{value:'மாநிறம்',label:'மாநிறம்'}
    			     ],
    			caste:[  
    	    	            {value:0,label:'-தேர்வு செய்யவும்-'},
    	    	            {id:1,value:"விஸ்வகர்மா ",label:"விஸ்வகர்மா ",casteid:1},{id:2,value:"விஸ்வகர்மா ",label:"விஸ்வகர்மா ",casteid:2}//{value:"நாடார்",label:"நாடார்"},{value:"அசைவப்பிள்ளைமார்",label:"அசைவப்பிள்ளைமார்"},{value:"சைவப்பிள்ளை",label:"சைவப்பிள்ளை"},{value:"இல்லத்து பிள்ளைமார்",label:"இல்லத்து பிள்ளைமார்"},{value:"ஆசாரியர்",label:"ஆசாரியர்"},{value:"யாதவர்",label:"யாதவர்"},{value:"அகமுடையார்",label:"அகமுடையார்"},{value:"நாயுடு",label:"நாயுடு"},{value:"கள்ளர்",label:"கள்ளர்"},{value:"மறவர்",label:"மறவர்"},{value:"செட்டியார்",label:"செட்டியார்"},{value:"கிறிஸ்தவர்",label:"கிறிஸ்தவர்"},{value:"முதலியார்",label:"முதலியார்"},{value:"PR",label:"PR"},{value:"PL",label:"PL"},{value:"ரெட்டியார்",label:"ரெட்டியார்"},{value:"கவுண்டர்",label:"கவுண்டர்"},{value:"முஸ்லீம்",label:"முஸ்லீம்"},{value:"கம்மவார் நாயுடு",label:"கம்மவார் நாயுடு"},{value:"அருந்ததியர்",label:"அருந்ததியர்"},{value:"நாயர்",label:"நாயர்"},{value:"மூப்பனார்",label:"மூப்பனார்"},{value:"மருத்துவர்",label:"மருத்துவர்"},{value:"வீரசைவம்",label:"வீரசைவம்"},{value:"வண்ணார்",label:"வண்ணார்"},{value:"வன்னியர்",label:"வன்னியர்"},{value:"செளராஷ்டிரா",label:"செளராஷ்டிரா"},{value:"நாயக்கர்",label:"நாயக்கர்"},{value:"வேளார்",label:"வேளார்"},{value:"உடையார்",label:"உடையார்"},{value:"சாலியர்",label:"சாலியர்"},{value:"மறுமணம்",label:"மறுமணம்"},		
    	    		     ],
    			     
    		     subcaste:[
	    	            {value:0,label:'ஜாதி உட்பிரிவு தேர்வு செய்யவும்'},{id:1,value:'விஸ்வகர்மா ',label:'விஸ்வகர்மா ',casteid:1},{id:2,value:'விஸ்வகர்மா ',label:'விஸ்வகர்மா ',casteid:2}
	    		     ],
    		     education:[
   	    	            {value:0,label:'-தேர்வு செய்யவும்-'}, 
   	    	            		{value:"1",label:"Engineering"},
				   	    	      {value:"2",label:"Bachelors"},
				   	    	      {value:"3",label:"Masters"},
				   	    	      {value:"4",label:"Doctorate"},
				   	    	      {value:"5",label:"Diploma"},
				   	    	      {value:"6",label:"Undergraduate"},
				   	    	      {value:"7",label:"Associates degree"},
				   	    	      {value:"8",label:"Honours degree"},
				   	    	      {value:"9",label:"Trade school"},
				   	    	      {value:"10",label:"High school"},
				   	    	      {value:"11",label:"Less than high school"}
   	    		     ],
   	    		        
   	    		     brothers:[
   	    		           	{value:0,label:0},{value:1,label:1},{value:2,label:2},{value:3,label:3},{value:4,label:4},{value:5,label:5},{value:6,label:6},{value:7,label:7},{value:8,label:8},{value:9,label:9},{value:10,label:10}
   	    		           ],
					star:[           
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"மேஷம்"},{value:"அசுவதி",label:"அசுவதி",id:"மேஷம்"},{value:"பரணி",label:"பரணி",id:"மேஷம்"},{value:"கார்த்திகை",label:"கார்த்திகை",id:"மேஷம்"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"ரிஷபம்"},{value:"கார்த்திகை",label:"கார்த்திகை",id:"ரிஷபம்"},{value:"ரோஹினி",label:"ரோஹினி",id:"ரிஷபம்"},{value:"மிருகஷீரிஷம்",label:"மிருகஷீரிஷம்",id:"ரிஷபம்"},
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"மிதுனம்"},{value:"மிருகஷீரிஷம்",label:"மிருகஷீரிஷம்",id:"மிதுனம்"} , {value:"திருவாதிரை",label:"திருவாதிரை",id:"மிதுனம்"},{value:"புனர்பூசம்",label:"புனர்பூசம்",id:"மிதுனம்"},
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"கடகம்"},{value:"புனர்பூசம்",label:"புனர்பூசம்",id:"கடகம்"},{value:"பூசம்",label:"பூசம்",id:"கடகம்"},{value:"ஆயில்யம்",label:"ஆயில்யம்",id:"கடகம்"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"சிம்மம்"},{value:"மகம்",label:"மகம்",id:"சிம்மம்"},{value:"பூரம்",label:"பூரம்",id:"சிம்மம்",},{value:"உத்திரம்",label:"உத்திரம்",id:"சிம்மம்"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"கன்னி"},{value:"உத்திரம்",label:"உத்திரம்",id:"கன்னி"}, {value:"ஹஸ்தம்",label:"ஹஸ்தம்",id:"கன்னி"},{value:"சித்திரை",label:"சித்திரை",id:"கன்னி"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"துலாம்"},{value:"சித்திரை",label:"சித்திரை",id:"துலாம்"}, {value:"ஸ்வாதி",label:"ஸ்வாதி",id:"துலாம்"},{value:"விசாகம்",label:"விசாகம்",id:"துலாம்"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"விருச்சிகம்"},{value:"விசாகம்",label:"விசாகம்",id:"விருச்சிகம்"}, {value:"அனுஷம்",label:"அனுஷம்",id:"விருச்சிகம்"},{value:"கேட்டை",label:"கேட்டை",id:"விருச்சிகம்"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"தனுசு"},{value:"மூலம்",label:"மூலம்",id:"தனுசு"},{value:"பூராடம்",label:"பூராடம்",id:"தனுசு"},{value:"உத்திராடம்",label:"உத்திராடம்",id:"தனுசு"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"மகரம்"},{value:"உத்திராடம்",label:"உத்திராடம்",id:"மகரம்"}, {value:"திருவோணம்",label:"திருவோணம்",id:"மகரம்"},{value:"அவிட்டம்",label:"அவிட்டம்",id:"மகரம்"},
							
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"கும்பம்"},{value:"அவிட்டம்",label:"அவிட்டம்",id:"கும்பம்"}, {value:"சதயம்",label:"சதயம்",id:"கும்பம்"},{value:"பூரட்டாதி",label:"பூரட்டாதி",id:"கும்பம்"},
						{value:"0",label:"-தேர்வு செய்யவும்-",id:"மீனம்"},{value:"பூரட்டாதி",label:"பூரட்டாதி",id:"மீனம்"}, {value:"உத்திரட்டாதி",label:"உத்திரட்டாதி",id:"மீனம்"},{value:"ரேவதி",label:"ரேவதி",id:"மீனம்"}
						],  
				rasi:[{value:"0",label:"-தேர்வு செய்யவும்-"},
				      	{value:"மேஷம்",label:"மேஷம்"},{value:"ரிஷபம்",label:"ரிஷபம்"},{value:"மிதுனம்",label:"மிதுனம்"},
						{value:"கடகம்",label:"கடகம்"},{value:"சிம்மம்",label:"சிம்மம்"},{value:"கன்னி",label:"கன்னி"},
						{value:"துலாம்",label:"துலாம்"},{value:"விருச்சிகம்",label:"விருச்சிகம்"},{value:"தனுசு",label:"தனுசு"},
						{value:"மகரம்",label:"மகரம்"},{value:"கும்பம்",label:"கும்பம்"},{value:"மீனம்",label:"மீனம்"},
					],
				lagnam:[{value:"0",label:"-தேர்வு செய்யவும்-"},
				        	{value:"மேஷம்",label:"மேஷம்"},
							{value:"ரிஷபம்",label:"ரிஷபம்"},
							{value:"மிதுனம்",label:"மிதுனம்"},
							{value:"கடகம்",label:"கடகம்"},
							{value:"சிம்மம்",label:"சிம்மம்"},
							{value:"கன்னி",label:"கன்னி"},
							{value:"துலாம்",label:"துலாம்"},
							{value:"விருச்சிகம்",label:"விருச்சிகம்"},
							{value:"தனுசு",label:"தனுசு"},
							{value:"மகரம்",label:"மகரம்"},
							{value:"கும்பம்",label:"கும்பம்"},
							{value:"மீனம்",label:"மீனம்"}
				        ],
				  di:[{value:"0",label:"-தேர்வு செய்யவும்-"},
				      {value:"குரு",label:"குரு"},
						{value:"சனி",label:"சனி"},
						{value:"புதன்",label:"புதன்"},
						{value:"கேது",label:"கேது"},
						{value:"வியாழன்",label:"வியாழன்"},
						{value:"சுக்கிரன்",label:"சுக்கிரன்"},
						{value:"சூரியன்",label:"சூரியன்"},
						{value:"சந்திரன்",label:"சந்திரன்"},
						{value:"செவ்வாய்",label:"செவ்வாய்"},
						{value:"ராகு",label:"ராகு"},
				      ],
				   mdt:[{value:"0",label:"-தேர்வு செய்யவும்-"},
							{value:"Myself",label:"என்னுடைய / Myself"},
							{value:"Son",label:"மகன் / Son"},
							{value:"Daughter",label:"மகள் / Daughter"},
							{value:"Brother",label:"சகோதரன் / Brother"},
							{value:"Sister",label:"சகோதரி / Sister"},
							{value:"Relative",label:"உறவினர் / Relative"},
							{value:"Friend",label:"நண்பன் / Friend"}
				        ],
				        religion :[{value:"0",label:"மதம் தேர்வு செய்யவும்"},
				        	{value:"Hindhu",label:"இந்து / Hindhu"},
							{value:"Christian",label:"கிரிஸ்துவர் / Christian"},
							{value:"Musliam",label:"முஸ்லீம் / Musliam"}
				        	],
				        	
							
				         jobtype :[{value:"0",label:" தேர்வு செய்யவும்"},
					        	{value:"gov",label:"அரசு வேலை"},
								{value:"pvt",label:"தனியார் வேலை"},{value:"own",label:"சொந்த தொழில்"}],			
				};
		  
	return {
		 $get: function() {
             return {
                     getdata: function() {
                         return data;
                     },
                     getAge:function(birthday){
                   		    var ageDifMs = Date.now() - birthday.getTime();
                   		    var ageDate = new Date(ageDifMs); 
                   		    return Math.abs(ageDate.getUTCFullYear() - 1970);
                     }
                 };
             }
	};
});
