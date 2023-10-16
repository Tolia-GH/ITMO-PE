import {allReducers} from "./reducer/reducer";
import {createStore} from "redux";
export const Store = createStore(allReducers);
