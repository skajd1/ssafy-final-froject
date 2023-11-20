import { ref, computed } from "vue";
import { defineStore } from "pinia";
// import { getTripInfoById } from "@/api/TripApi.js";
const useTripStore = defineStore("useTripStore", () => {
  const tripItems = ref([]);
  const initItems = () => {
    tripItems.value = [];
  };

  return {
    initItems,
    tripItems,
  };
});
export { useTripStore };
