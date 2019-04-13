<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="formApp" ng-controller="formCtrl">
	<form ng-submit="submitForm()">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			<label for="namel"><b>Name</b></label> <input type="text"
				placeholder="Enter Name" ng-model="name" name="name" required>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" ng-model="email" name="email" required>

			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" ng-model="password" name="psw" required>

			<label for="psw-repeat"><b>Repeat Password</b></label> <input
				type="password" placeholder="Repeat Password" ng-model="rePassword"
				name="psw-repeat" required>
			<hr>
			<p>
				By creating an account you agree to our <a href="#">Terms &
					Privacy</a>.
			</p>

			<button type="submit" class="registerbtn">Register</button>
		</div>

		<div class="container signin">
			<p>
				Already have an account? <a href="#">Sign in</a>.
			</p>
		</div>
	</form>
</div>
