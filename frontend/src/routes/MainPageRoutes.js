import {Route, Routes} from "react-router-dom";
import {hasRole, isAuthenticated} from "../services/auth/auth";
import Profile from "../components/profile/Profile";
import Logout from "../components/logout/Logout";

const MainPageRoutes = ({user}) => {
  return (
      <Routes>

        {isAuthenticated(user) && <Route path='/profile'
                                         element={Profile()}/>}
        {isAuthenticated(user) && <Route path='/logout'
                                         element={<Logout/>}/>}
      </Routes>
  );
};

export default MainPageRoutes;
