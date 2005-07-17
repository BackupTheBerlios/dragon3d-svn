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
<?php mosLoadModules ( 'top' ); ?>
</div>
<?php
/*
 * Main Content
 */
?>
<div class="body" style="padding:20px 20px 20px 20px;">
	<table cellpadding="3" cellspacing="0" border="0" style="width:70%;">
		<tr>
			<td>
				<?php mosMainBody(); ?>
			</td>
		</tr>
	</table>
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