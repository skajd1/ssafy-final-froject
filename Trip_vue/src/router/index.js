import { createRouter, createWebHistory } from "vue-router";
import Main from "../views/Main.vue";
import TripList from "../views/Trip/TripListView.vue";
import TripSelect from "../views/Trip/TripSelectView.vue";
import TripDetail from "../views/Trip/TripDetailView.vue";
import PlanList from "../views/Plan/PlanListView.vue";
import PlanDetail from "../views/Plan/PlanDetail.vue";
import PlanInsert from "../views/Plan/PlanInsert.vue";
import Board from "../views/Board/BoardList.vue";
import BoardDetail from "../views/Board/BoardDetail.vue";
import BoardInsert from "../views/Board/BoardInsert.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Main",
      component: Main,
    },
    {
      path: "/tripselect",
      name: "TripSelect",
      component: TripSelect,
    },
    {
      path: "/triplist/:sido/:gugun/:theme",
      name: "TripList",
      component: TripList,
    },
    {
      path: "/triplist/:tid",
      name: "TripDetail",
      component: TripDetail,
    },
    {
      path: "/myplan",
      name: "PlanList",
      component: PlanList,
    },
    {
      path: "/myplan/:pid",
      name: "PlanDetail",
      component: PlanDetail,
    },
    {
      path: "/plan/insert",
      name: "PlanInsert",
      component: PlanInsert,
    },
    {
      path: "/board",
      name: "BoardList",
      component: Board,
    },
    {
      path: "/board/:bid",
      name: "BoardDetail",
      component: BoardDetail,
    },
    {
      path: "/board/insert",
      name: "BoardInsert",
      component: BoardInsert,
    },
  ],
});

export default router;
