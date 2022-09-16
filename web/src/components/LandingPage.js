import '../style/LandingPage.css';
import SignIn from "./signin/SignIn";
import SignUp from "./signup/Signup";

function LandingPage() {
  return (
    <div className="App">
      <header className="App-header">
        <p>
          <SignIn/>
        </p>
        <p><SignUp/></p>
      </header>
    </div>
  );
}

export default LandingPage;
