// Vuex 조립
import { createStore } from 'vuex'
import * as getters from './getters'
import * as mutations from './mutations'
import * as actions from './actions'

const state = {
  notices: "기본값",
  reportedUsers: '기본값',
  noticeDetailData: '기본값',
  myinfo:[],
  accessToken:'',// 
  userId:'',
}

const root = createStore({
  namespaced: true,
  state,
  getters,
  mutations,
  actions
})

export default root
