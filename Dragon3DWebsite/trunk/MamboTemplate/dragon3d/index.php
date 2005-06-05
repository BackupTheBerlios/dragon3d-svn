<?php
defined( '_VALID_MOS' ) or die( 'Direct Access to this location is not allowed.' );
$iso = split( '=', _ISO );
echo '<?xml version="1.0" encoding="'. $iso[1] .'"?' .'>';
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <?php if ( $my->id ) initEditor(); ?>
    <meta http-equiv="Content-Type" content="text/html; <?php echo _ISO; ?>" />
    <?php mosShowHead(); ?>
    <link rel="stylesheet" type="text/css" href="<?php echo $GLOBALS['mosConfig_live_site']; ?>/templates/dragon3d/css/default.css" />
  </head>
<body>
<div class="header"><img src="images/dragon3d.png" border="0" alt="Dragon 3D Project" /></div>
<div class="navigation">
	<a class="navigation" href="index.php">About</a>&nbsp;&nbsp;::&nbsp;&nbsp;
    <a class="navigation" href="news.php">News</a>&nbsp;&nbsp;::&nbsp;&nbsp;
    <a class="navigation" href="dragon3d.php">Dragon3D</a>&nbsp;&nbsp;::&nbsp;&nbsp;
    <a class="navigation" href="contact.php">Contact</a>
</div>
<?php
/*
 * Main Content
 */
?>
<div class="body" style="padding:20px 20px 20px 20px;">
	<table cellpadding="3" cellspacing="0" border="0" style="width:70%;">
		<tr>	
			<th style="border:1px solid #cccccc; background-color:#eeeeee; font-weight:bold;padding-left:10px;text-align:left;">About</th>
		</tr>
		<tr>
			<td style="border-bottom:1px solid #cccccc; border-left:1px solid #cccccc; border-right:1px solid #cccccc;">
			Dragon3D is a Java framework for the <a href="http://www.pixar.com/renderman/">Renderman (c) Interface</a>. 
			Every RIB element is defined in it's own object and is created in a <a href="http://en.wikipedia.org/wiki/Factory_method_pattern">factory</a> once it is read from a RIB input file.
			<br/>
			The first functional implementation of this framework is a Renderman (c) Interface Bytestream file to a Renderman (c) XML format convertor.<br/>
			<br/>
			The project page can be found <a href="https://developer.berlios.de/projects/dragon3d/">here</a>
			<br/><br/>
			And <a href="http://svn.berlios.de/viewcvs/dragon3d/Dragon3D/trunk/">here</a> you can browse the repository
			<br/><br/>
			And of course a <a href="http://dragon3d.blogspot.com/">developer blog</a>
			<br/><br/>
			This project is hosted by <a href="http://www.berlios.de/">Berlios</a>
			<br/><br/>
			</td>
		</tr>
	</table>
	<br/>
</div>
<?php
/*
 * Footer
 */
?>
<div class="footer">
	<table cellpadding="0" cellspacing="0" border="0" style="width:100%;">
		<tr>
			<td style="padding-left:10px;">&copy;2005 cyberroadie</td>
		</tr>
	</table>
</div>
<img style="position:absolute; top:15px; right:15px;" src="images/icondragon3d.png" alt="icon" border="0" />
</body>
</html>