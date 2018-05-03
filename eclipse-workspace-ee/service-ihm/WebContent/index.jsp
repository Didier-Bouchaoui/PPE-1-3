<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Moyenne étudiant</title>
</head>
<body>
<form action="moyenne" method="get">
            <fieldset>
  				<label for="matricule">Matricule étudiant </label>
                <input type="text" id="matricule" name="matricule" value="" size="5" maxlength="5" />
                <br/>
                <input type="submit" value="valider" class="sansLabel" />
                <br />
            </fieldset>
</form>
</body>
</html>