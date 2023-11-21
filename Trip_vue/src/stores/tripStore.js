import { ref, reactive, computed } from "vue";
import { defineStore } from "pinia";
import { getTripInfoById } from "@/api/TripApi.js";
const useTripStore = defineStore("useTripStore", () => {
  const tripItems = ref([]);
  const selectedTrip = ref({});
  const initTripItems = () => {
    tripItems.value = [];
  };
  const key = ref("");
  const getTripItems = (cid) => {
    getTripInfoById(
      cid,
      (res) => {
        tripItems.value.push(res.data[0]);
      },
      (err) => {
        console.log(err);
      }
    );
  };
  const select = (trip) => {
    selectedTrip.value = trip;
  };
  const keyword = computed({
    get: () => key.value,
    set: (value) => (key.value = value),
  });
  const items = computed(() => tripItems.value);
  const selected = computed(() => selectedTrip.value);

  return {
    initTripItems,
    getTripItems,
    keyword,
    items,
    select,
    selected,
  };
});
export { useTripStore };
