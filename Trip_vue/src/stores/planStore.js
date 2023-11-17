import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { getMyPlans, getPlanItems } from "@/api/PlanApi.js";
// 라우터 변경 테스트 해보기
const usePlanStore = defineStore("usePlanStore", () => {
  //1. state
  const plans = ref([]);
  const plan = ref({});
  const Items = ref([]);

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
  return {
    allPlan,
    all,
    planItems,
    items,
  };
});

export { usePlanStore };
