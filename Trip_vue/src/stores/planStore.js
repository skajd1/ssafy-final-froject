import { ref, computed, reactive } from "vue";
import { defineStore } from "pinia";
import { getMyPlans, getPlanItems } from "@/api/PlanApi.js";

const usePlanStore = defineStore("usePlanStore", () => {
  //1. state
  const plans = ref([]);
  const Items = ref([]);
  const insertItems = ref([]);

  //2. action
  const allPlan = (uid) => {
    getMyPlans(
      uid,
      (res) => {
        plans.value = res.data;
      },
      (err) => {
        console.log(err);
      }
    );
  };
  const planItems = (pid) => {
    getPlanItems(
      pid,
      (res) => {
        Items.value = res.data;
      },
      (err) => {
        console.log(err);
      }
    );
  };

  //3. getter
  const all = computed(() => plans.value);

  const items = computed(() => Items.value);

  const insert = computed(() => insertItems.value);

  // 여행지 추가
  const id = ref(1);
  const plandetail = reactive([]); // { date, cost, memo }

  const addPlanItem = ([date, cost, memo]) => {
    plandetail.push({ id: id.value++, date: date, cost: cost, memo: memo });
    console.log(plandetail);
  };
  const deletePlanItem = (id) => {
    let index = plandetail.findIndex((todoItem) => todoItem.id === id);
    plandetail.splice(index, 1);
  };

  return {
    allPlan,
    all,
    planItems,
    items,
    insert,

    addPlanItem,
    deletePlanItem,
  };
});

export { usePlanStore };
