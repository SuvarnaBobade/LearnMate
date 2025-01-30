<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            background-color: black;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 70%;
            margin: 50px auto;
            background-color: rgb(152, 217, 224);
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            font-size: 25px;
            color: rgb(2, 19, 19);
        }

        h1 {
            text-align: center;
            color: rgb(2, 19, 19);
        }

        .profile-details {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
            margin-top: 20px;
            font-size: 20px;
        }

        .profile-details label {
            font-weight: bold;
            color: rgb(2, 19, 19);
        }

        .profile-details input,
        .profile-details select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: rgb(227, 242, 237);
            font-size: 18px;
        }

        .profile-details input[readonly] {
            background-color: rgb(217, 221, 185);
        }

        .btn-container {
            text-align: center;
            margin-top: 20px;
        }

        .edit-btn {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: rgb(6, 69, 94);
            color: white;
            border-radius: 10px;
        }

        .edit-btn:hover {
            background-color: rgb(5, 50, 70);
        }

        p {
            font-size: 17px;
        }
    </style>
    
</head>

<body>
<form action="update" method="post">
    <div class="container">
        <h1>User Profile</h1>
        <div class="profile-details">
            <div>
                <label for="fname">First Name:</label>
                
                <input type="text" name="fname" value="${fname}" >
            </div>

            <div>
                <label for="lname">Last Name:</label>
                <input type="text" name="lname" value="${lname}" >
            </div>

            <div>
                <label for="email">Email:</label>
                <input type="email" name="email" value="${email}" readonly>
            </div>

            <div>
                <label for="password">Password:</label>
                <input type="password" name="password" value="${password}" readonly>
            </div>

            <div>
                <label for="address">Address:</label>
                <input type="text" name="address" value="${address}" >
            </div>

            <div>
                <label for="state">State:</label>
                <input type="text" name="state" value="${state}" >
            </div>

            <div>
                <label for="city">City:</label>
                <input type="text" name="city" value=" ${city}" >
            </div>

            <div>
                <label for="country">Country:</label>
                <input type="text" name="country" value="${country}" >
            </div>

            <div>
                 <label for="mo_number">Mobile Number:</label>
   				 <input type="text" name="mobile_no" value="${mobile_no}" >
    		</div>

            <div>
                <label for="aadhar_no">Aadhar No:</label>
                <input type="text" name="aadhar_no" value="${aadhar_no} " >
            </div>

            <div>
                <label for="age">Age:</label>
                <input type="number" name="age" value="${age}" >
            </div>

            <div>
                <label for="gender">Gender:</label>
                <select name="gender"  >
                    <option value="${Male}">Male</option>
                    <option value="${Female}">Female</option>
                    <option value="${Other}">Other</option>
                </select>
            </div>

            <div>
                <label for="dob">Date of Birth:</label>
                <input type="date" name="dob" value="${dob}" >
            </div>
            <div>
				<label for="degree">Department:</label>
            	<select name="degree"  >
                    	<option value="${bcs}">BCS</option>
                    	<option value="${mcs}">MCS</option>
			</select>
			</div>
            <div>
                <label for="passing_year">Passing Year:</label>
                <input type="number" name="passing_year" value="${passing_year}" >
            </div>

            <div>
                <label for="marks">Marks:</label>
                <input type="text" name="marks" value="${marks}" >
            </div>
        </div>

        <div class="btn-container">
            <button type="button" class="edit-btn" onclick="window.location.href='profile.jsp'">Cancel</button>
            <button type="submit" class="edit-btn" >Update</button>
            
        </div>
    </div>
</form>

</body>

</html>
