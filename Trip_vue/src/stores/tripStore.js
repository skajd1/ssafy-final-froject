import { ref, reactive, computed, watch } from "vue";
import { defineStore } from "pinia";
import { getTripInfoById } from "@/api/TripApi.js";
import { getTripInfo } from "@/api/TripApi.js";

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

  // 여행지 조회
  const tripList = reactive([]);
  const searchdata = reactive({
    keyword: "",
    sido: "",
    gugun: "",
  });
  const thema = reactive([]);

  const sido = computed({
    get: () => searchdata.sido,
    set: (value) => (searchdata.sido = value),
  });

  const gugun = computed({
    get: () => searchdata.gugun,
    set: (value) => (searchdata.gugun = value),
  });

  const addTema = (themaCode) => {
    thema.push(themaCode);
  };

  const getTripList = () => {
    getTripInfo(
      searchdata,
      (res) => {
        tripList.value = res.data;
        console.log(searchdata);
        console.log(res.data);
        setTimeout(() => {
          console.log(res);
        }, 1000);
      },
      (err) => {
        console.log(err);
      }
    );
  };

  // watch(
  //   thema,
  //   () => {
  //     getTripInfo(
  //       searchdata,
  //       (res) => {
  //         tripList.value = res.data;
  //       },
  //       (err) => {
  //         console.log(err);
  //       }
  //     );
  //   },
  //   { deep: true }
  // );

  const lists = computed(() => tripList.value);
  const searchData = computed(() => searchdata);

  return {
    initTripItems,
    getTripItems,
    getTripList,
    select,
    searchData,
    keyword,
    items,
    selected,
    addTema,
    lists,
    sido,
    gugun,
    thema,
  };
});

export { useTripStore };
