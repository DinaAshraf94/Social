<!DOCTYPE html>

<head>
<meta charset="utf-8">
<title>Login page</title>
<style>

.button
{
    width:90px;
    height: 30px;
    color: blue;
    line-height: 20px;
    padding-bottom: 2px;
    vertical-align: middle;
    font-family: font-family:verdana;
    font-size: 20px;
  
}
body 
{
   background-image: url("${pageContext.request.contextPath}/pic2.png");
}
p {border-style: solid;}
p.solid 
{
 border-bottom-style: solid;
 border-width: 120px;
 border-width: 120px;
 border-color: #000000;

}
h1{ 
    display: block;
    font-size: 2em;
    margin-top: 0.67em;
    margin-bottom: 0.67em;
    margin-left: 0;
    margin-right: 0;
    font-weight: bold;
}
</style>
</head>

<body class="body" class="solid">
<img src="${pageContext.request.contextPath}/pic.jpg"  style="width:304px;height:228px">
<div class="container"  style="width:400px; margin-right:auto; margin-left:auto; color:blue;">

	<section id="content">
		<form action="/social/home" method="post">
		
			<h1 style="color:white" >Login Form</h1>
			<div>
			<input type="text" placeholder="email" required="" name="email" /><br/><br/>
			</div>
			<div>
				<input type="password" placeholder="Password" required="" name="password"/><br/><br/>
			</div>
			<div>
				<input type="submit" value="Login" class="button"/>
			
			</div>
		</form><!-- form -->
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>