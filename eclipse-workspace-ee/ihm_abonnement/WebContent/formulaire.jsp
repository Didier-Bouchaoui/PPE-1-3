<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription à la Newsletter</title>
</head>
<body>
<form action="ihm" method="post">
            <fieldset>
  				<table><tr>
                <td><label for="nom">Nom</label></td>
                <td><input type="text"  name="nom" value="" size="32" maxlength="32" required /></td> 
                <br/></tr>
                <tr>
                 <td><label for="prenom">Prénom</label></td>
                <td><input type="text"  name="prenom" value="" size="32" maxlength="32" required /></td>
                <br/>
                <tr>
                <td><label for="courriel">Email</label></td>
                <td><input type="text"  name="courriel" value="" size="32" maxlength="128" required /></td>
                </tr>
                </table>
                <input type="submit" value="S'inscrire" class="sansLabel" />
                <br/>                
            </fieldset>
</form>
</body>
</html>