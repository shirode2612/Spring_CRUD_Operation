
<html>
<head>
<style>
   span
   {
     font-size: 22px;
     color: white;
     margin: 620px;
     text-align: center;
     font-style: bold;
   } 
   
    body{
font-family: sans-serif;
background: rgb(2,0,36);
background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,121,118,1) 79%, rgba(0,212,255,1) 100%);

}
.box {
    width: 420px;
    height:320px;
    padding: 15px;
    border-radius: 13px;
    position: absolute;
    top: 10%;
    left: 35%;
    background: #191919;
    text-align: center;
    transition: 0.25s;
    margin-top: 30px
}

.box input[type="text"] {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #3498db;
    padding: 10px 10px;
    width: 250px;
    outline: none;
    color: white;
    border-radius: 14px;
    transition: 0.25s
}
 #p{
   text-align: bottom;
   color:white
   }

.box h1 {
    color: white;
    text-transform: uppercase;
    font-weight: 250;
    font-style: italic;
}

.box input[type="text"]:focus{
    width: 300px;
    border-color: #2ecc71
}
.box.buttdiv
{
   text-align: centre;
   
}

.box input[type=button] {
    border: 0;
    padding:8px;
    background: none;
    text-align: center;
    margin:5px;
    border: 2px solid #2ecc71;
    outline: none;
    color: white;
    border-radius: 6px;
    transition: 0.25s;
    cursor: pointer
}

.box input[type=button]:hover {
    background: #2ecc71
}

</style>

<script>

var xmlhttp;
var buttonClicked;
var message;

		function sendData(button)
		{
			var cid = document.categoryform.cid.value;
			var cname = document.categoryform.cname.value;
		  
			var javascriptobject={"cid":cid,"cname":cname}
			xmlhttp = new XMLHttpRequest();
			
			 buttonClicked = button.value;
			if(buttonClicked=="post")
			{	
				 message = "Data Is Save Successfully";
				xmlhttp.open("post","categoryapi/saveCategory");
			}
			else
			{
				 message = "Data Is Update Successfully";
				xmlhttp.open("put","categoryapi/updateCategory");
			}
			xmlhttp.onload=displayResponse;
			
			var jsonstring = JSON.stringify(javascriptobject);
			
			xmlhttp.setRequestHeader('Content-type','application/json')
			
			xmlhttp.send(jsonstring);
			
			alert("Data Is sent to API");
		}


		function displayResponse()
		{
			document.getElementById("message").innerHTML= message;

			alert(xmlhttp.responseText);
		}

		function getData(button)
		{
			var cid = document.categoryform.cid.value;
		  
			xmlhttp = new XMLHttpRequest();
			
			 buttonClicked = button.value;
			
			if(buttonClicked =="get")
			{
				 message = "Data Is retrieved Successfully";
			     xmlhttp.open("get","categoryapi/getCategory/"+cid);
			}
			else
			{
				 message = "Data Is Delete Successfully";
			     xmlhttp.open("delete","categoryapi/deleteCategory/"+cid);
			}
		
			
			xmlhttp.onload=displayResponse2;
			
			xmlhttp.send();
			
		}

/* function displayResponse2()
{
	document.getElementById("message").innerHTML= message;
	
	var jsonstring = xmlhttp.responseText;
	
	var javascriptobject = JSON.parse(jsonstring); //parse converts JSON string to javaScript object
	
	//javascriptobject ==> {cid:2,name:"stationary"}
	
	var name = javascriptobject.name;
	document.categoryform.name.value = name;
} */

function displayResponse2()
{
	var jsonstring = xmlhttp.responseText;
	var obj=JSON.parse(jsonstring);
	
	var cname=obj.cname;
	if(obj.message!=undefined)
	{
		document.categoryform.cname.value = "";
		document.getElementById("message").innerHTML= obj.message;
	
	}else
	{
		document.categoryform.cname.value = cname;
		document.getElementById("message").innerHTML= message;

	}

}
function getAllData()
{
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onload=displayResponse3;
    xmlhttp.open("get","categoryapi/getAllCategory");
    xmlhttp.send();
}

function displayResponse3()
{
	alert(xmlhttp.responseText);
	
	var allJSONStrings = xmlhttp.responseText;
	
	var p1 = document.getElementById("p1");
	
	var data="";
	
	/*for(var i=0; allJSONStrings.length;i++)
			{
		
			}*/
			
	p1.innerHTML = allJSONStrings;
}
</script>

</head>
<body>

<span id ="message">Waiting</span>
<form action="" name=categoryform class="box">
<h1>CRUD</h1> 
<input type="text" name="cid" placeholder="Enter Category ID"> 
<input type="text" name="cname" placeholder="Enter Data">  
<div class="buttdiv">
<input type=button value=post onclick="sendData(this)">
<input type=button value=get onclick="getData(this)">
<input type=button value=put onclick="sendData(this)">
<input type=button value=delete onclick="getData(this)">
<input type=button value=getAll onclick="getAllData()">
</div>
</form> 
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<br>
<br>
<br>
<br>
<br>

<br>
<br>
<br>
<br>
<br>

<br>
<br>
<br>
<br>
<br>





<!--  <span id ="message">Waiting</span>
<form action="" name=categoryform>
<input name=cid><br><br>
<input name=cname><br><br>
<input type=button value=post onclick="sendData(this)">
<input type=button value=get onclick="getData(this)">
<input type=button value=put onclick="sendData(this)">
<input type=button value=delete onclick="getData(this)">
<input type=button value=getAll onclick="getAllData()">
</form> -->

<p id="p1" style="color:white;">All Data</p>
 

 
 </body>
  
</html>